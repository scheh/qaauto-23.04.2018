import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSubmitLoginPage extends LinkedinBasePage
{
    public LinkedinSubmitLoginPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "global-alert-queue")
    private WebElement errorBlock;

    @FindBy(id = "control_gen_1")
    private WebElement errorMessage;

    @FindBy(id = "session_key-login-error")
    private WebElement invalidLoginText;

    @FindBy(id = "session_password-login-error")
    private WebElement invalidPassword;

    @FindBy(id = "session_key-login")
    private WebElement submitLogin;

    @FindBy(id = "session_password-login")
    private WebElement submitPassword;

    @FindBy(id = "btn-primary")
    private WebElement submitButton;



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

    public String getErrorTextSubmitPage()
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
