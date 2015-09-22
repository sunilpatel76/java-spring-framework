package aaradhya.patel.application.module.homepage;


import aaradhya.patel.application.page.LoginPage;
import aaradhya.patel.application.page.config.NextGenConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes = NextGenConfiguration.class)
public class LoginPageTest extends AbstractTestNGSpringContextTests{

    @Autowired
    LoginPage loginPage;

    @Test
    public void loginPageTest(){
//        loginPage.loginNextGen("", "");
    }

}
