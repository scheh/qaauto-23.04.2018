package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage
{
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

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//li[@id='profile-nav-item']" )
    private WebElement profileNavItem;


    public LinkedinHomePage(WebDriver webDriver)
    {
        super(webDriver);
        //PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded()
    {
        return profileNavItem.isDisplayed();
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

    public LinkedinSearchResults search(String searchTerm)
    {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return PageFactory.initElements(webDriver, LinkedinSearchResults.class);
    }

}
