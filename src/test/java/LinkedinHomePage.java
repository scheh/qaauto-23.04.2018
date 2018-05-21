import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LinkedinHomePage
{
    private WebDriver webDriver;

    private WebElement homePageIcon;
    private WebElement myNetworkIcon;
    private WebElement jobsIcon;
    private WebElement messagingIcon;
    private WebElement notificationsIcon;
    private WebElement searchField;

    public LinkedinHomePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        initHomeElement();
    }

    public void initHomeElement()
    {
        homePageIcon = webDriver.findElement(By.id("feed-tab-icon"));
        myNetworkIcon =  webDriver.findElement(By.id("mynetwork-tab-icon"));
        jobsIcon = webDriver.findElement(By.id("jobs-tab-icon"));
        messagingIcon = webDriver.findElement(By.id("messaging-tab-icon"));
        notificationsIcon = webDriver.findElement(By.id("notifications-tab-icon"));
        searchField = webDriver.findElement(By.id("nav-search-controls-wormhole"));
    }


    public String getCurrentURLHomePage()
    {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitleHomePage()
    {
        return webDriver.getTitle();
    }

    public boolean isHomePageIconPresence()
    {
        return homePageIcon.isDisplayed();
    }

    public boolean isMyNetworkIconPresence()
    {
        return myNetworkIcon.isDisplayed();
    }

    public boolean isJobsIconPresence()
    {
        return jobsIcon.isDisplayed();
    }

    public boolean isMessagingIconPresence()
    {
        return messagingIcon.isDisplayed();
    }

    public boolean isNotificationsIconPresence()
    {
        return notificationsIcon.isDisplayed();
    }

    public boolean isSearchFieldisPresent()
    {
        return searchField.isDisplayed();
    }

}
