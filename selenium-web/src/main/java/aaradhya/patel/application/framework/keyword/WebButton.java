package aaradhya.patel.application.framework.keyword;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebButton extends Page{
    private WebElement webElement;

    public WebButton(WebElement element){
        this.webElement = element;
    }

    public void click() {
        this.webElement.click();
    }
    public void mouseClick(){
        Actions actions = new Actions(driver());
        actions.moveToElement(this.webElement).perform();
        this.webElement.click();
    }

    public WebElement scrollIntoView(){
        if (driver() != null)
            ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(true);", this.webElement);
        return this.webElement;
    }


}
