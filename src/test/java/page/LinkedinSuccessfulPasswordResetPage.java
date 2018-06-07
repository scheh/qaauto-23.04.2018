package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for Successful password reset page
 *
 */
public class LinkedinSuccessfulPasswordResetPage extends LinkedinBasePage
{
    @FindBy (id ="reset-password-submit-button")
    private WebElement goHomeButton;

    /**
     * @return go home button
     * Method checking page is loaded
     */
    public boolean isPageLoaded()
    {
        return goHomeButton.isDisplayed();
    }

    /**
     * @return home page
     * Method checking user come to home page
     */
    public LinkedinHomePage goHomePage()
    {
        goHomeButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    /**
     * @param webDriver
     * Constructor webdriver for Successfyul password reset page
     */
    public LinkedinSuccessfulPasswordResetPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
