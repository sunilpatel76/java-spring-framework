package aaradhya.patel.application;

import aaradhya.patel.application.page.LoginPage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class ApplicationConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer getApplicationProperties(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public LoginPage loginPage(){
        return new LoginPage();
    }


}
