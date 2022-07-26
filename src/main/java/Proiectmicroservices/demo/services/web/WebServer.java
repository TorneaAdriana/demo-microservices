package Proiectmicroservices.demo.services.web;

import Proiectmicroservices.demo.services.registration.RegistrationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {

    public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";


    public static void main(String[] args) {

        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebAccountService accountService(){
        return new WebAccountService(ACCOUNTS_SERVICE_URL);
    }

    @Bean
    public WebAccountController accountController(){
        return new WebAccountController(accountService());
    }

    @Bean
    public HomeController homeController(){
        return new HomeController();
    }
}
