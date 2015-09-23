package aaradhya.patel.application.framework;

import aaradhya.patel.application.framework.keyword.*;
import aaradhya.patel.application.framework.logger.TestLogger;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Serializable;

public abstract class Page {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    private static TestLogger logger = new TestLogger("SUNIL");

    private static final int MAX_WAIT = 60;

    public static Page browser(final String browserName){
        return new Browser(browserName);
    }

    public static class Browser extends Page implements Serializable {
        private WebDriver webDriver = null;
        public Browser(String browser){
            if (browser.equalsIgnoreCase("chrome")){
                webDriver = new ChromeDriver();
            }
            threadLocal.set(webDriver);
        }
    }
    public void navigate(final String url){
        if (url.isEmpty()){
            throw new IllegalArgumentException("Cannot open url when the url expression is null.");
        }
        driver().get(url);
    }
    public static void driverQuit(){
        if (driver() != null){
            driver().quit();
        }
    }

    public static WebEdit webEdit(final By by){
        WebElement webElement = null;
        try {
            logger.logInfo("sdsadsadsadsadsa");
            webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfElementLocated(by));

            ((JavascriptExecutor) driver()).executeScript("arguments[0].style.border='2px outset red'", webElement);
        }catch (ElementNotFoundException e){
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

    public static WebDriver driver(){
        return threadLocal.get();
    }

}
