package aaradhya.patel.application.test.homepage;

import aaradhya.patel.application.AbstractWebApplication;
import aaradhya.patel.application.elements.AccountSetup;
import aaradhya.patel.application.framework.Page;
import aaradhya.patel.application.framework.utility.Utility;
import aaradhya.patel.application.page.DashboardPage;
import aaradhya.patel.application.elements.Enroll;
import aaradhya.patel.application.elements.Header;
import aaradhya.patel.application.page.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Component
public class LoginPageTest extends AbstractWebApplication {

    @Autowired
    LoginPage loginPage;

    @Autowired
    DashboardPage dashboardPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Page.browser(webBrowser).navigate(applicationURL);
    }

    @Test
    public void loginPageTest (){
        String emailAddress = Utility.generateEmailAddress();
        Page.webLink(Header.LINK_ENROLL).click();
        Page.webButton(Enroll.BUTTON_NEXT).click();

        Page.webEdit(AccountSetup.INPUT_EMAIL).sendKeys(emailAddress);
        Page.webEdit(AccountSetup.INPUT_RE_EMAIL).sendKeys(emailAddress);


        System.out.println("");

    }

    @AfterClass
    public void tearDown(){
        Page.quit();
    }

}
