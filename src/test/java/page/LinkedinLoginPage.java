package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {
    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(className = "link-forgot-password")
    private WebElement forgotPasswordLink;


    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    public LinkedinHomePage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
        //return new page.LinkedinHomePage(webDriver);
    }

    public LinkedinSubmitLoginPage submitPageLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinSubmitLoginPage.class);
    }

    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }


    public boolean isEmailFieldDisplayed() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public String getCurrentURLLoginPage() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitleLoginPage() {
        return webDriver.getCurrentUrl();
    }


/* How return one of three pages.

    public <T> T login(String email, String password) {
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
    }
*/

}