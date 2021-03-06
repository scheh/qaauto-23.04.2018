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


    /**
     * @param webDriver
     * Constructor for WebDriver
     */
    public LinkedinHomePage(WebDriver webDriver)
    {
        super(webDriver);
        //PageFactory.initElements(webDriver, this);
    }

    /**
     * @return
     * Method checking that page is loaded
     */
    public boolean isPageLoaded()
    {
        return profileNavItem.isDisplayed();
    }

    /**
     * @return
     * Method checking URL for Home Page
     */
    public String getCurrentURLHomePage()
    {
        return webDriver.getCurrentUrl();
    }

    /**
     * @return
     * Method checking is title correct for Home Page
     */
    public String getCurrentTitleHomePage()
    {
        return webDriver.getTitle();
    }

    /**
     * @return
     * Method checking Icon for Home Page is present
     */
    public boolean isHomePageIconPresence()
    {
        return homePageIcon.isDisplayed();
    }

    /**
     * @return
     * Method for checking My Network Icon presence
     */
    public boolean isMyNetworkIconPresence()
    {
        return myNetworkIcon.isDisplayed();
    }

    /**
     * @return
     * Method checking Jobs Icon is present
     */
    public boolean isJobsIconPresence()
    {
        return jobsIcon.isDisplayed();
    }

    /**
     * @return
     * Method checking Messaging Icon is present
     */
    public boolean isMessagingIconPresence()
    {
        return messagingIcon.isDisplayed();
    }

    /**
     * @return
     * Method checking Notification Icon is present
     */
    public boolean isNotificationsIconPresence()
    {
        return notificationsIcon.isDisplayed();
    }

    /**
     * @return
     * Method checking Search field Icon is present
     */
    public boolean isSearchFieldisPresent()
    {
        return searchField.isDisplayed();
    }

    /**
     * @param searchTerm
     * @return
     * Method for fill the searxch field and click ENTER button
     */
    public LinkedinSearchResults search(String searchTerm)
    {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return PageFactory.initElements(webDriver, LinkedinSearchResults.class);
    }

}
