package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for Set new password page
 */
public class LinkedinSetNewPasswordPage extends LinkedinBasePage
{
    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    /**
     * @param webDriver
     * Constructor webdriver for set new password page
     */
    public LinkedinSetNewPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return request password reset page
     * Method for submit new password
     */
    public LinkedinRequestPasswordResetPage passwordResetPage()
    {
        newPasswordField.sendKeys("Password123");
        confirmPasswordField.sendKeys("Password123");
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }

    /**
     * @return new password field
     * Method checking page is loaded
     */
    public boolean isPageLoaded()
    {
        return newPasswordField.isDisplayed();
    }

    /**
     * @return confirm password field and reset password submit button
     * Checking page is displayed
     */
    public boolean isDisplayed()
    {
        return confirmPasswordField.isDisplayed() && resetPasswordSubmitButton.isDisplayed();
    }

    /**
     * @return Successful Password Reset Page
     * Method for new password submiting
     */
    public LinkedinSuccessfulPasswordResetPage submitNewPassword()
    {
        newPasswordField.sendKeys("Password123");
        confirmPasswordField.sendKeys("Password123");
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinSuccessfulPasswordResetPage.class);
    }

}
