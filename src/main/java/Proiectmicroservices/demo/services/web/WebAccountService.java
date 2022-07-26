package Proiectmicroservices.demo.services.web;


import Proiectmicroservices.demo.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class WebAccountService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    protected Logger logger=Logger.getLogger(WebAccountService.class.getName());

    public WebAccountService(String serviceUrl){
        this.serviceUrl=serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    @PostConstruct
    public void demoOnly(){
        logger.warning("The RestTemplate request factory is "+ restTemplate.getRequestFactory().getClass());
    }

    public Account findByNumber(String accountNumber){
        logger.info("findByNumber() invoked for: "+ accountNumber);
        try{
            return restTemplate.getForObject(serviceUrl+ "/accounts/{number}", Account.class,accountNumber);
        }catch(Exception e){
            logger.severe(e.getClass()+":"+e.getLocalizedMessage());
            return null;
        }
    }

    public List<Account> byOwnerContains(String name){
        logger.info("byOwnerContains() invoked: for "+ name);

        Account[] accounts=null;

        try{
            accounts=restTemplate.getForObject(serviceUrl+"/accounts/owner/{name}",Account[].class,name);
        }catch(HttpClientErrorException e)
        {

        }

        if(accounts==null || accounts.length==0){
            return null;
        }
        else
            return Arrays.asList(accounts);
    }

    public Account getByNumber(String accountNumber){

        Account account=restTemplate.getForObject(serviceUrl+"/accounts/{number}",Account.class,accountNumber);

        if(account==null){
            throw new AccountNotFoundException(accountNumber);
        }
        else
            return account;
    }
}
