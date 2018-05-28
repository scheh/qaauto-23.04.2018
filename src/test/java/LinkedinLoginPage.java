import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage
{
    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinHomePage login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    public LinkedinSubmitLoginPage submitPageLogin(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinSubmitLoginPage.class);
    }

    public boolean isEmailFieldDisplayed()
    {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed()
    {
        return passwordField.isDisplayed();
    }

    public boolean isSignInButtonDisplayed()
    {
        return signInButton.isDisplayed();
    }

    public String getCurrentURLLoginPage()
    {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitleLoginPage()
    {
        return webDriver.getCurrentUrl();
    }

}
