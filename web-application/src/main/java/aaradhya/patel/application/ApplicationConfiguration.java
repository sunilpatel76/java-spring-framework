package aaradhya.patel.application;


import aaradhya.patel.application.page.LoginPage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@EnableAutoConfiguration
public class ApplicationConfiguration {

    @Bean
    public LoginPage loginPage(){
        return new LoginPage();
    }
}
