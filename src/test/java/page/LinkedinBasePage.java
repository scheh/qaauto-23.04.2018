package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/** Base page class with WebDriver
 *
 */
public abstract class LinkedinBasePage
{
    protected WebDriver webDriver;

    /**
     * Method for searching email + clicking on the link inside
     */
    protected static GMailService gMailService = new GMailService();

/**
 * Constructor of BasePage
 * @param webDriver - webDriver instance
 */
    public LinkedinBasePage(WebDriver webDriver)

    {
        this.webDriver = webDriver;
    }

    /**
     * @return
     * Method for URL checking
     */
    public String getCurrentURLHomePage() {
        return webDriver.getCurrentUrl();
    }

    /**
     * @return
     * Method for Home page title checking
     */
    public String getCurrentTitleHomePage() {
        return webDriver.getTitle();
    }

    /**
     * @return
     * Method for checking is Page Loaded
     */
    abstract boolean isPageLoaded();

    /**
     * @param webElement
     * @param timeOutInSeconds
     * @return
     * Method for element become clickable
     */
    public WebElement waitUntilElementsClickable(WebElement webElement, int timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     * @param webElement
     * @param timeOutInSeconds
     * @return
     * Method for element become visible
     */
    public WebElement waitUntilElementsVisible(WebElement webElement, int timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
