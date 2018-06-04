package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccessfulPasswordResetPage extends LinkedinBasePage
{
    @FindBy (id ="reset-password-submit-button")
    private WebElement goHomeButton;

    public boolean isPageLoaded()
    {
        return goHomeButton.isDisplayed();
    }

    public LinkedinHomePage goHomePage()
    {
        goHomeButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    public LinkedinSuccessfulPasswordResetPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
