package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

public abstract class LinkedinBasePage
{
    protected WebDriver webDriver;

    protected static GMailService gMailService = new GMailService();

    public LinkedinBasePage(WebDriver webDriver)

    {
        this.webDriver = webDriver;
    }

    public String getCurrentURLHomePage() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitleHomePage() {
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded();

    public WebElement waitUntilElementsClickable(WebElement webElement, int timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public WebElement waitUntilElementsVisible(WebElement webElement, int timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
