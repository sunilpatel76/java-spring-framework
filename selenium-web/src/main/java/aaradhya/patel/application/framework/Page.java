package aaradhya.patel.application.framework;

import aaradhya.patel.application.framework.keyword.WebEdit;
import aaradhya.patel.application.framework.keyword.WebLink;
import aaradhya.patel.application.framework.logger.TestLogger;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public abstract class Page {

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    public static TestLogger logger = new TestLogger("SUNIL");
    private static final int MAX_WAIT = 45;
    private static final int MIN_WAIT = 15;
    private static final int MED_WAIT = 30;

    public static Page browser(final String browser){
        return new PageBrowser(browser);
    }

    private static class PageBrowser extends Page implements Serializable {

        private WebDriver webDriver;
        public PageBrowser(String browser){
            if (browser.isEmpty())
                throw new IllegalArgumentException("cannot open browser while browser is null");

            if (browser.equalsIgnoreCase("chrome")){
                webDriver = new ChromeDriver();
                webDriver.manage().timeouts().pageLoadTimeout(MIN_WAIT, TimeUnit.SECONDS);
                webDriver.manage().timeouts().implicitlyWait(MED_WAIT, TimeUnit.SECONDS);
                webDriver.manage().timeouts().setScriptTimeout(MED_WAIT, TimeUnit.SECONDS);
            }
            threadLocal.set(webDriver);
        }
    }

    public void navigate(String url){
        if (url.isEmpty()){
            throw new IllegalArgumentException("Cannot open url when the url expression is null.");
        }
        driver().get(url);
    }
    public static String getCurrentUrl(){
        return driver().getCurrentUrl();
    }
    public static void quit(){
        if (driver() != null) driver().quit();
    }


    private static WebDriver driver(){
        return threadLocal.get();
    }

    public static WebLink webLink(final By by){
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfElementLocated(by));

            highlightElement(driver(), webElement);
        }catch (ElementNotFoundException e){
        }
        return new WebLink(webElement);
    }
    public static WebEdit webEdit(final By by){
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver(), MED_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfElementLocated(by));

            highlightElement(driver(), webElement);
        }catch (ElementNotFoundException e){
            //logger.logInfo(by.toString() +", presence of element is missing from the current page");
        }
        return new WebEdit(webElement);
    }

    private static void highlightElement(WebDriver driver, WebElement element){
        if (driver() != null)
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px outset red'", element);
    }


}
