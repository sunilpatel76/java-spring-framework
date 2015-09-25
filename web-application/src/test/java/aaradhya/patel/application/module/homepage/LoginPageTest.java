package aaradhya.patel.application.module.homepage;

import aaradhya.patel.application.ApplicationConfiguration;
import aaradhya.patel.application.framework.Page;
import aaradhya.patel.application.page.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
@Service
public class LoginPageTest extends AbstractTestNGSpringContextTests{

    @Autowired
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        Page.browser("Chrome").navigate("https://qascc.securustech.net/login");
    }

    @Test
    public void loginPageTest(){
        loginPage.loginNextGen("spatel@securus.com", "Password1");
    }

    @AfterClass
    public void tearDown(){
        Page.quit();
    }

}
