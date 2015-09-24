package aaradhya.patel.application.page;


import aaradhya.patel.application.framework.Page;
import aaradhya.patel.application.framework.keyword.WebEdit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    private By text_userName = By.xpath("//*[@title='Type your email address']");

    public void loginNextGen(String userName, String passWd){
        Page.webEdit(text_userName).sendKeys("spatel@securustech.com");
        System.out.println(Page.getCurrentUrl());


    }
}
