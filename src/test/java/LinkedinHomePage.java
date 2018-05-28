import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class LinkedinHomePage extends LinkedinBasePage
{
    public LinkedinHomePage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "feed-tab-icon")
    private WebElement homePageIcon;

    @FindBy(id = "mynetwork-tab-icon")
    private WebElement myNetworkIcon;

    @FindBy(id = "jobs-tab-icon")
    private WebElement jobsIcon;

    @FindBy(id = "messaging-tab-icon")
    private WebElement messagingIcon;

    @FindBy(id = "notifications-tab-icon")
    private WebElement notificationsIcon;

    @FindBy(id = "nav-search-controls-wormhole")
    private WebElement searchField;

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
