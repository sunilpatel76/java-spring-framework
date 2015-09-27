package aaradhya.patel.application.page;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.By;

/**
 * Created by Sunil on 9/27/2015.
 */
public class DashboardPage {
    By link_search = By.xpath("//a[@data-toggle='dropdown']//div[text()='Search']");

    public void navigateCommunicationRecords(){
        Page.webLink(link_search).click();
        Page.webLink(link_search).getText();

    }
}
