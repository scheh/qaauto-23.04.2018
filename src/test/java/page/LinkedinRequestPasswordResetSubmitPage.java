package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Class for Request password reset submit page
 */
public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage
{
    @FindBy(xpath = "//*[@id='sendemail-form']/div[1]/a[1]")
    private WebElement anotherEmailButton;

    @FindBy(id = "resend-url")
    private WebElement resendUrlButton;

    /**
     * @param webDriver
     * Constructor for webdriver RequestPasswordResetSubmitPage
     */
    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return anotherEmailButton
     * Method checking page is loaded
     */
    public boolean isPageLoaded()
    {
        return anotherEmailButton.isDisplayed();
    }

    /**
     * @return resend button
     * Method checking resend button is displayed
     */
    public boolean isresendButtonDisplayed()
    {
        return resendUrlButton.isDisplayed();
    }

    /**
     * @return link
     * Method for clicking on link inside the email
     */
    public LinkedinSetNewPasswordPage navigateToLinkFromEmail()
    {
        gMailService.connect();
        System.out.println(LinkedinRequestPasswordResetPage.gMailMessage);
        String resetPasswordLink = StringUtils.substringBetween(LinkedinRequestPasswordResetPage.gMailMessage,
                "click <a href="+'"',
                '"'+" style=").replace("&amp;","&");
        System.out.println(resetPasswordLink);
        webDriver.get(resetPasswordLink);
        return PageFactory.initElements(webDriver, LinkedinSetNewPasswordPage.class);
    }
}

