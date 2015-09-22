package aaradhya.patel.application.page;


import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.By;


public class LoginPage {
    private By text_userName = By.xpath("");

    public void loginNextGen(String userName, String passWd){
        Page.browser("Chrome").navigate("");
        Page.webEdit(text_userName).replaceKeys("spatel@securustechnologies.com");
    }
}
