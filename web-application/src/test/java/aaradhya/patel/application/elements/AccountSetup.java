package aaradhya.patel.application.elements;

import org.openqa.selenium.By;


public interface AccountSetup {
    By INPUT_EMAIL = By.xpath(".//*[@id='email']");
    By INPUT_RE_EMAIL = By.xpath("//*[@id='remail_confirm']");
}
