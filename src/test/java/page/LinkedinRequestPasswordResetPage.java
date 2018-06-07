package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for Request password reset page
 */
public class LinkedinRequestPasswordResetPage extends LinkedinBasePage
{
    /**
     * Static message for gMail service
     */
    public static  String gMailMessage;

    @FindBy(id = "username")
    private WebElement setEmailField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordButton;

    /**
     * @param webDriver
     * Constructor for Request password reset page
     */
    public LinkedinRequestPasswordResetPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return email and password fields
     * Method checking page is loaded
     */
    public boolean isPageLoaded()
    {
        return setEmailField.isDisplayed() && resetPasswordButton.isDisplayed();
    }

//    public boolean isresendButtonDisplayed()
//    {
//        return resetPasswordButton.isDisplayed();
//    }

    /**
     * @return
     * Method checking for email is received
     */
    public LinkedinRequestPasswordResetSubmitPage submitUserEmail()
    {
        gMailService.connect();
        setEmailField.sendKeys("scheh@adyax.com");
        resetPasswordButton.click();
        gMailMessage = gMailService.waitMessage("Sergey, here's the link to reset your password", "scheh@adyax.com", "security-noreply@linkedin.com", 60);
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetSubmitPage.class);
    }
}

