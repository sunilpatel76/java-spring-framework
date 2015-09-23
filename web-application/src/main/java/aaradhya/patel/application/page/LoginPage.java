package aaradhya.patel.application.page;


import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    private By text_userName = By.xpath("//*[@title='Type your email address']");

    public void loginNextGen(String userName, String passWd){
        Page.browser("Chrome").navigate("https://securustech.net/friends");
        Page.webEdit(text_userName).replaceKeys(userName);

    }
}
