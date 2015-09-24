package aaradhya.patel.application.framework.keyword;


import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser extends Page{
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    private WebDriver webDriver;

    public Browser(String browser){
        if (browser.isEmpty()){
            throw new IllegalArgumentException("cannot open browser while browser is null");
        }

        if (browser.equalsIgnoreCase("chrome")){
            webDriver = new ChromeDriver();
        }
        threadLocal.set(webDriver);
    }
    public void navigate(String url){
        if (url.isEmpty()){
            throw new IllegalArgumentException("Cannot open url when the url expression is null.");
        }

        driver().get(url);
    }
    public WebDriver driver(){
        return threadLocal.get();
    }
    public void quitDriver(){
        if (driver() != null) {
            logger.logInfo("killing browser as requested");
            driver().quit();
        }
        logger.logInfo("killing browser requested, no browser found");
    }

}
