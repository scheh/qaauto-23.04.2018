import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkedinLoginPage
{
    private  WebDriver webDriver;

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements()
    {
        emailField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }

    public void login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
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
