import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinSubmitLoginPage
{
        private WebDriver webDriver;

        private WebElement errorBlock;
        private WebElement errorMessage;
        private WebElement invalidLoginText;
        private WebElement invalidPassword;
        private WebElement submitLogin;
        private WebElement submitPassword;
        private WebElement submitButton;


    public LinkedinSubmitLoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements()
    {

        errorBlock = webDriver.findElement(By.id("global-alert-queue"));
        errorMessage = webDriver.findElement(By.id("control_gen_1"));
        invalidLoginText = webDriver.findElement(By.id("session_key-login-error"));
        invalidPassword = webDriver.findElement(By.id("session_password-login-error"));
        submitLogin = webDriver.findElement(By.id("session_key-login"));
        submitPassword = webDriver.findElement(By.id("session_password-login"));
        submitButton = webDriver.findElement(By.id("btn-primary"));
    }

    public String getURLSubmitPage()
    {
        return webDriver.getCurrentUrl();
    }

    public String getTitleSubmitPage()
    {
        return webDriver.getTitle();
    }

    public boolean errorBlockSubmitPage()
    {
        return errorBlock.isDisplayed();
    }

    public String errorTextSubmitPage()
    {
        return errorMessage.getText();
    }

    public boolean invalidLoginTextSubmitPage()
    {
        return invalidLoginText.isDisplayed();
    }

    public String invalidPasswordTextSubmitPage()
    {
        return invalidPassword.getText();
    }

    public boolean invalidPasswordSubmitPage()
    {
        return invalidPassword.isDisplayed();
    }

    public String unRegisteredEmail()
    {
        return invalidLoginText.getText();
    }

    public boolean emailFieldSubmitPage()
    {
        return submitLogin.isDisplayed();
    }

    public boolean passwordFieldSubmitPage()
    {
        return submitPassword.isDisplayed();
    }

    public boolean signInButtonPresence()
    {
        return submitButton.isDisplayed();
    }

}
