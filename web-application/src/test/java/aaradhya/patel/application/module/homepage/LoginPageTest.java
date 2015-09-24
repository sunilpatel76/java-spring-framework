package aaradhya.patel.application.module.homepage;


import aaradhya.patel.application.framework.Page;
import aaradhya.patel.application.framework.keyword.Browser;
import aaradhya.patel.application.page.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes = aaradhya.patel.application.ApplicationConfiguration.class)
@Component
@TestExecutionListeners(inheritListeners = false, listeners = DependencyInjectionTestExecutionListener.class)
public class LoginPageTest extends AbstractTestNGSpringContextTests{

    @Autowired
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
    }

    @Test
    public void loginPageTest(){
        loginPage.loginNextGen("spatel@securus.com", "");
        Page.browser("").quitDriver();


    }

    @AfterClass
    public void tearDown(){
    }

}
