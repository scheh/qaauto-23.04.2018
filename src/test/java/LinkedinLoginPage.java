import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LinkedinLoginPage
{
    private  WebDriver webDriver;

    private WebElement emailField;
    private WebElement passwordField;
    private  WebElement signInButton;

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

    public boolean isSignInButtonDisplayed()
    {
        return signInButton.isDisplayed();
    }

    public String getCurrentURL()
    {
        return webDriver.getCurrentUrl();
    }

    public  String getCurrentTitle()
    {
        return webDriver.getCurrentUrl();
    }
}

/*
public class LinkedinLoginPage
{
    private WebDriver webDriver;

    public LinkedinLoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        emailField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }
    private WebElement emailField;
    private WebElement passwordField;
    public WebElement signInButton;

    public void login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        //signInButton.click();

    }
    public boolean setSignInButtonPresence()
    {
        Assert.assertTrue(signInButton.isDisplayed(), "Sign in button is absent");
        return true;
    }

}
*/
