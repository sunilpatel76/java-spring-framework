package aaradhya.patel.application.page;


import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

public class LoginPage {
    By text_userName = By.xpath("//*[@id='username']");
    By text_passWord = By.xpath(".//*[@id='password']");
    By button_login = By.xpath("//button[text()='Login']");

    public void loginNextGen(String userName, String passWd){
        Page.webEdit(text_userName).sendKeys(userName);
        Page.webEdit(text_passWord).sendKeys(passWd);

    }
}
