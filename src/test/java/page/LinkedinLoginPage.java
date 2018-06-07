package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for Login page
 */
public class LinkedinLoginPage extends LinkedinBasePage {
    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(className = "link-forgot-password")
    private WebElement forgotPasswordLink;


    /**
     * @param webDriver
     * Constructor for webdriver ( Login page )
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return
     * Method checking is page loaded
     */
    @Override
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    /**
     * @param email
     * @param password
     * @return
     * Method for logining on Home page
     */
    public LinkedinHomePage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
        //return new page.LinkedinHomePage(webDriver);
    }

    /**
     * @param email
     * @param password
     * @return
     * Method for logining to submit page
     */
    public LinkedinSubmitLoginPage submitPageLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinSubmitLoginPage.class);
    }

    /**
     * @return
     * Method for licking on Forgot password link
     */
    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }


    /**
     * @return email field
     * Method for checking is email field present
     */
    public boolean isEmailFieldDisplayed() {
        return emailField.isDisplayed();
    }

    /**
     * @return password field
     * Method for checking password field is displayed
     */
    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    /**
     * @return URL for Login page
     * Method for checking URL for login page
     */
    public String getCurrentURLLoginPage() {
        return webDriver.getCurrentUrl();
    }

    /**
     * @return tile login page
     * Method checking title for login page
     */
    public String getCurrentTitleLoginPage() {
        return webDriver.getCurrentUrl();
    }



//How return one of three pages.

    /**
     * @param email
     * @param password
     * @param <T>
     *
     * @return One of the three pages depending on the method will be done
     */

    /*public <T> T login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys((password));
        signInButton.click();
        if (getCurrentURLLoginPage().contains("/feed")) {
            return (T) new page.LinkedinHomePage(webDriver);
        }
        if (getCurrentURLLoginPage().contains("/login-submit")) {
            return (T) new page.LinkedinSubmitLoginPage(webDriver);
        } else {
            return (T) this;
        }
    }*/

}