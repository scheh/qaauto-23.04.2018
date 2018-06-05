package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage
{
    public static  String gMailMessage;

    @FindBy(id = "username")
    private WebElement setEmailField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordButton;

    public LinkedinRequestPasswordResetPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded()
    {
        return setEmailField.isDisplayed() && resetPasswordButton.isDisplayed();
    }

//    public boolean isresendButtonDisplayed()
//    {
//        return resetPasswordButton.isDisplayed();
//    }

    public LinkedinRequestPasswordResetSubmitPage submitUserEmail()
    {
        gMailService.connect();
        setEmailField.sendKeys("scheh@adyax.com");
        resetPasswordButton.click();
        gMailMessage = gMailService.waitMessage("Sergey, here's the link to reset your password", "scheh@adyax.com", "security-noreply@linkedin.com", 60);
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetSubmitPage.class);
    }
}

