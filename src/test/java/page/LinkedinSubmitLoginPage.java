package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for Submit login page
 */
public class LinkedinSubmitLoginPage extends LinkedinBasePage
{
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


    /**
     * @param webDriver
     * Constructor webdriver for Submit login page
     */
    public LinkedinSubmitLoginPage(WebDriver webDriver)
    {
        super(webDriver);
        //PageFactory.initElements(webDriver, this);
    }

    /**
     * @return Current URL
     * Method checking for URL
     */
    public String getURLSubmitPage()
    {
        return webDriver.getCurrentUrl();
    }

    /**
     * @return Title
     * Method checking title for submit page
     */
    public String getTitleSubmitPage()
    {
        return webDriver.getTitle();
    }

    /**
     * @return error block message
     * Method checking error block submit page
     */
    public boolean errorBlockSubmitPage()
    {
        return errorBlock.isDisplayed();
    }

    /**
     * @return error message field
     * Method checking error text submit page is present
     */
    public String getErrorTextSubmitPage()
    {
        return errorMessage.getText();
    }

    /**
     * @return invalid login text
     * Checking invalidLoginTextSubmitPage is present
     */
    public boolean invalidLoginTextSubmitPage()
    {
        return invalidLoginText.isDisplayed();
    }

    /**
     * @return invalid password
     * Method checking invalidPasswordTextSubmitPage is present
     */
    public String invalidPasswordTextSubmitPage()
    {
        return invalidPassword.getText();
    }

    /**
     * @return invalid password
     * Method checking invalidPasswordSubmitPage is displayed
     */
    public boolean invalidPasswordSubmitPage()
    {
        return invalidPassword.isDisplayed();
    }

    /**
     * @return invalid login text
     * Method checking error message about unregistered email
     */
    public String unRegisteredEmail()
    {
        return invalidLoginText.getText();
    }

    /**
     * @return submit login
     * Method checking email field for submit page is present
     */
    public boolean emailFieldSubmitPage()
    {
        return submitLogin.isDisplayed();
    }

    /**
     * @return submit password field
     * Method checking password field is present on submit page
     */
    public boolean passwordFieldSubmitPage()
    {
        return submitPassword.isDisplayed();
    }

    /**
     * @return submit button
     * Method checking sign in button is present
     */
    public boolean signInButtonPresence()
    {
        return submitButton.isDisplayed();
    }

    /**
     * @return error block
     * Method checking that page is loaded
     */
    boolean isPageLoaded()
    {
        return errorBlock.isDisplayed();
    }
}
