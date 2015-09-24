package aaradhya.patel.application.framework;

import aaradhya.patel.application.framework.keyword.*;
import aaradhya.patel.application.framework.logger.TestLogger;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    public static TestLogger logger = new TestLogger("SUNIL");
//    public Logger logger = LogManager.getLogger(getClass().getSimpleName());
    private static final int MAX_WAIT = 60;

    public static WebEdit webEdit(final By by){
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfElementLocated(by));

            ((JavascriptExecutor) driver()).executeScript("arguments[0].style.border='2px outset red'", webElement);
        }catch (ElementNotFoundException e){
            logger.logInfo(by.toString() +", presence of element is missing from the current page");
        }

        return new WebEdit(webElement);
    }
    public static WebLink webLink(final By by){
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfElementLocated(by));

            ((JavascriptExecutor) driver()).executeScript("arguments[0].style.border='1px outset red'", webElement);
        }catch (ElementNotFoundException e){
            //message
        }

        return new WebLink(webElement);
    }
    public static Browser browser(final String browser){
        return new Browser(browser);
    }

    private static WebDriver driver(){
//        return Browser.driver();
        return null;
    }


}
