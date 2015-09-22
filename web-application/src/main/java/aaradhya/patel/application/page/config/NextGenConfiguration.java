package aaradhya.patel.application.page.config;


import aaradhya.patel.application.page.LoginPage;
import org.springframework.context.annotation.*;

@Configuration
public class NextGenConfiguration {

    @Bean
    public LoginPage loginPage(){
        return new LoginPage();
    }
}
