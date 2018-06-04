package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;


public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage
{
    @FindBy(xpath = "//*[@id='sendemail-form']/div[1]/a[1]")
    private WebElement anotherEmailButton;

    @FindBy(id = "resend-url")
    private WebElement resendUrlButton;

    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded()
    {
        return anotherEmailButton.isDisplayed();
    }

    public boolean isresendButtonDisplayed()
    {
        return resendUrlButton.isDisplayed();
    }


    public LinkedinSetNewPasswordPage navigateToLinkFromEmail()
    {
        GMailService gMailService = new GMailService();
        gMailService.connect();
        System.out.println(LinkedinRequestPasswordResetPage.gMailMessage);
        String resetPasswordLink = StringUtils.substringBetween(LinkedinRequestPasswordResetPage.gMailMessage,"click <a href="+'"', '"'+" style=").replace("&amp;","&");
        System.out.println(resetPasswordLink);
        webDriver.get(resetPasswordLink);
        return PageFactory.initElements(webDriver, LinkedinSetNewPasswordPage.class);
    }
}

