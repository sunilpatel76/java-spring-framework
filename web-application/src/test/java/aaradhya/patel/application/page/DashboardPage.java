package aaradhya.patel.application.page;

import aaradhya.patel.application.framework.Page;
import org.openqa.selenium.By;

public class DashboardPage {

    private static final By LINK_SEARCH = By.xpath("//a[@data-toggle='dropdown']//div[text()='Search']");

    public void navigateCommunicationRecords(){
        Page.webLink(LINK_SEARCH).click();
        Page.webLink(LINK_SEARCH).getText();
    }


}
