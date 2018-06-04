package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class LinkedinResetPasswordTest extends LinkedinBaseTest
{
    @Test
    public void successfulPasswordResetTest()
    {
        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "Request password reset page is not loaded.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail();
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "Password request password reset submit page is not loaded.");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isDisplayed(),
                "Set new password page is not loaded.");

        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
                "Password request password reset submit page is not loaded.");

        LinkedinSuccessfulPasswordResetPage linkedinSuccessfulPasswordResetPage = linkedinSetNewPasswordPage.submitNewPassword();
        Assert.assertTrue(linkedinSuccessfulPasswordResetPage.isPageLoaded(),
                "Successful password reset page is not loaded.");


        LinkedinHomePage linkedinHomePage = linkedinSuccessfulPasswordResetPage.goHomePage();

        Assert.assertEquals(linkedinHomePage.getCurrentURLHomePage(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong");

        Assert.assertTrue(linkedinHomePage.getCurrentTitleHomePage().contains("LinkedIn"),
                "Home page title is wrong.");

        Assert.assertTrue(linkedinHomePage.isHomePageIconPresence(),
                "Home page icon is absent");

    }
}
