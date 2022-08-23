package team.common;


import team.BookManagementApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BookManagementApplication.class })
public class CucumberSpingConfiguration {
    
}
