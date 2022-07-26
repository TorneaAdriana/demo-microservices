package Proiectmicroservices.demo;

import Proiectmicroservices.demo.accounts.AccountsConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@SpringBootTest(classes = AccountsConfiguration.class, properties = {"eureka.client.enabled=false"})
public class AccountsControllerIntegrationTests extends AbstractAccountControllerTests{
}
