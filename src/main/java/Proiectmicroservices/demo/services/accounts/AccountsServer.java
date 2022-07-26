package Proiectmicroservices.demo.services.accounts;

import Proiectmicroservices.demo.accounts.AccountRepository;
import Proiectmicroservices.demo.accounts.AccountsConfiguration;
import Proiectmicroservices.demo.services.registration.RegistrationServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@Import(AccountsConfiguration.class)
public class AccountsServer {

    @Autowired
    protected AccountRepository accountRepository;

    protected Logger logger = Logger.getLogger(AccountsServer.class.getName());


    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        // Tell server to look for accounts-server.properties or
        // accounts-server.yml
        System.setProperty("spring.config.name", "accounts-server");

        SpringApplication.run(AccountsServer.class, args);
    }
}
