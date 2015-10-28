package aaradhya.patel.application.framework.keyword;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebList {
    private WebElement webElement;

    public WebList(WebElement element){
        this.webElement = element;
    }

    public void selectByVisibleText(String listItem){
        Select select = new Select(webElement);
        boolean listFlag = false;

        List<WebElement> listElements = select.getOptions();
        for (WebElement element: listElements){
            if (element.getText().contains(listItem)){
                select.selectByVisibleText(element.getText());
                listFlag = true;
            }
        }
        if (!listFlag) {
            throw new NoSuchElementException("Cannot locate element with text: " + listItem);
        }
    }
}
