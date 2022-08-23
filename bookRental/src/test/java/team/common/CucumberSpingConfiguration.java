package team.common;


import team.BookRentalApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BookRentalApplication.class })
public class CucumberSpingConfiguration {
    
}
