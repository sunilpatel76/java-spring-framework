package aaradhya.patel.application.page;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    private By text_userName = By.xpath("");

    public void loginNextGen(String userName, String passWd){
        System.out.println(this.getClass().toString());

    }
}
