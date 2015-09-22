package aaradhya.patel.application.framework.keyword;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.WebElement;


public class WebLink extends Page {
    private WebElement webElement;

    public WebLink(WebElement element){
        this.webElement = element;
    }

    public void click(){
        this.webElement.click();
    }

    public String getText(){
        return this.webElement.getText().trim();
    }

}