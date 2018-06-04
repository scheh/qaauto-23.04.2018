package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage
{
    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    public LinkedinSetNewPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinRequestPasswordResetPage passwordResetPage()
    {
        newPasswordField.sendKeys("Password123");
        confirmPasswordField.sendKeys("Password123");
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }

    public boolean isPageLoaded()
    {
        return newPasswordField.isDisplayed();
    }

    public boolean isDisplayed()
    {
        return confirmPasswordField.isDisplayed();
    }

    public boolean isResetPasswordSubmitButtonDisplayed()
    {
        return resetPasswordSubmitButton.isDisplayed();
    }

    public LinkedinSuccessfulPasswordResetPage submitNewPassword()
    {
        newPasswordField.sendKeys("Password123");
        confirmPasswordField.sendKeys("Password123");
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinSuccessfulPasswordResetPage.class);
    }
}
