package aaradhya.patel.application.framework.keyword;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.WebElement;

public class WebEdit extends Page{

    private WebElement webElement;

    public WebEdit(WebElement element){
        this.webElement = element;
    }

    public void sendKeys(String keys){
        this.webElement.sendKeys(keys);
    }
    public void replaceKeys(String keys){
        this.webElement.clear();
        this.webElement.sendKeys(keys);
    }

    public String getAttribute(String name){
        return this.webElement.getAttribute(name);
    }

}
