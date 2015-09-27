package aaradhya.patel.application.test.homepage;

import aaradhya.patel.application.AbstractWebApplication;
import aaradhya.patel.application.framework.Page;
import aaradhya.patel.application.page.DashboardPage;
import aaradhya.patel.application.page.LoginPage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginPageTest extends AbstractWebApplication {

    @Autowired
    LoginPage loginPage;

    @Autowired
    DashboardPage dashboardPage;

    @BeforeClass
    public void setUp(){
        Page.browser(webBrowser).navigate(applicationURL);
    }

    @Test
    public void loginPageTest(){
        loginPage.loginNextGen(userName, passWd);
        dashboardPage.navigateCommunicationRecords();


    }

    @AfterClass
    public void tearDown(){
        Page.quit();
    }

}
