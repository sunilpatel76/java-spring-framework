package aaradhya.patel.application;

import aaradhya.patel.application.page.DashboardPage;
import aaradhya.patel.application.page.LoginPage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;

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

    @Bean
    public DashboardPage dashboardPage(){
        return new DashboardPage();
    }


}
