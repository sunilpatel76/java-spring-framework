package aaradhya.patel.application.framework.keyword;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;


public class WebLink {
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