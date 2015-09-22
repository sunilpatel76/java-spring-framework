package aaradhya.patel.application.framework.keyword;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.WebElement;

public class WebButton extends Page{
    private WebElement webElement;

    public WebButton(WebElement element){
        this.webElement = element;
    }

    public void click() {
        this.webElement.click();
    }
}
