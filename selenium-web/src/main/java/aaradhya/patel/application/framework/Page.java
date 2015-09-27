package aaradhya.patel.application.framework;

import aaradhya.patel.application.framework.keyword.WebButton;
import aaradhya.patel.application.framework.keyword.WebEdit;
import aaradhya.patel.application.framework.keyword.WebLink;
import aaradhya.patel.application.framework.logger.TestLogger;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class Page {

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
//    public static TestLogger logger = new TestLogger("SUNIL");
    private static final int MAX_WAIT = 45;
    private static final int MIN_WAIT = 15;
    private static final int MED_WAIT = 30;
    private static final Logger logger = LogManager.getLogger(Page.class);

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
                webDriver.manage().window().maximize();
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

    public static WebDriver driver(){
        return threadLocal.get();
    }

    public static WebLink webLink(final By by){
        List<WebElement> webElement = null;
        try {
            webElement=(new WebDriverWait(driver(), MAX_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

            highlightElement(driver(), webElement.get(0));
        }catch (Exception e){
            throw new NoSuchElementException("webLink: Unable to find the element, " + by.toString());
        }
        return new WebLink(webElement.get(0));
    }
    public static WebEdit webEdit(final By by){
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver(), MED_WAIT, 1000))
                    .until(ExpectedConditions.presenceOfElementLocated(by));

            highlightElement(driver(), webElement);
        }catch (ElementNotFoundException e){
        }
        return new WebEdit(webElement);
    }
    public static WebButton webButton(final By by){
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver(), MED_WAIT, 1000))
                    .until(ExpectedConditions.elementToBeClickable(by));
            highlightElement(driver(), webElement);
        }catch (ElementNotFoundException e){

        }
        return new WebButton(webElement);
    }


    private static void highlightElement(WebDriver driver, WebElement element){
        if (driver() != null)
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px outset red'", element);
    }


}
