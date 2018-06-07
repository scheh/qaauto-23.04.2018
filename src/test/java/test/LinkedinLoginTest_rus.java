package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinSubmitLoginPage;

/**
 * Class for login test
 */
public class LinkedinLoginTest_rus extends LinkedinBaseTest
{

    @DataProvider
    public Object[][] validDataProvider()
    {
        return new Object[][]
        {
                { "scheh@adyax.com", "Password0123" },
                { "SCHEH@ADYAX.COM", "Password0123" },

        };
    }

    @DataProvider
    public Object[][] invalidIncorrectEmailDataProvider()
    {
        return new Object[][]
        {
                {"schehadyaxcom", "Password"},
                {"SCH4534 *92459", "Password0123"},
                {"* 6745%^^7$$#_+", "&764yfhfifj"},
        };

    }
    @DataProvider
    public Object[][] invalidUnregisteredEmailDataProvider()
    {
        return new Object[][]
        {
                {"s@adyax.com", "Password"},
                {"cheh@adyax.com", "Passs999"},
                {"233@i.ua", "Passwordeer"},
                {"come@bigmir.net", "Oofjnfnff"},

        };
    }
    @DataProvider
    public Object[][] invalidPasswordDataProvider()
    {
        return new Object[][]
        {
                {"scheh@adyax.com", "Passsswwwo"},
                {"scheh@adyax.com", "Prjhfjfjff"},
                {"scheh@adyax.com", "478ifhjkfh"},
        };
    }
    @DataProvider
    public Object[][] emptyDataForEachFieldDataProvider()
    {
        return new Object[][]
        {
                {"scheh@adyax.com", ""},
                {"", "Password0123"},
                {"", ""},
                {" ", " "},
        };

    }


    /**
     * @param email
     * @param password
     * Test for successful login
     */
    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password)
    {

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is not displayed");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login-Submit page is not loaded");

        Assert.assertEquals(linkedinLoginPage.getCurrentURLLoginPage(),
                "https://www.linkedin.com/",
                "Login page URL is wrong");

        Assert.assertEquals(linkedinLoginPage.getCurrentTitleLoginPage(),
                "https://www.linkedin.com/",
                "Login page title is wrong");


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinHomePage.getCurrentURLHomePage(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong");

        Assert.assertTrue(linkedinHomePage.getCurrentTitleHomePage().contains("LinkedIn"),
                "Home page title is wrong.");

        Assert.assertTrue(linkedinHomePage.isHomePageIconPresence(),
                "Home page icon is absent");

        Assert.assertTrue(linkedinHomePage.isMyNetworkIconPresence(),
                "My Network icon is absent");

        Assert.assertTrue(linkedinHomePage.isJobsIconPresence(),
                "Jobs icon is absent");

        Assert.assertTrue(linkedinHomePage.isMessagingIconPresence(),
                "Messaging icon is absent");

        Assert.assertTrue(linkedinHomePage.isNotificationsIconPresence(),
                "Notifications icon is not displayed");

        Assert.assertTrue(linkedinHomePage.isSearchFieldisPresent(),
                "Search field is not displayed");


    }


    /**
     * @param email
     * @param password
     * Test for negative test Incorrect email
     */
    @Test(dataProvider = "invalidIncorrectEmailDataProvider")
    public void negativeLoginTestIncorrectLogin(String email, String password)
    {

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login-Submit page is not loaded");

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = linkedinLoginPage.submitPageLogin(email,password);

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidLoginTextSubmitPage(),
                "Error message is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.getErrorTextSubmitPage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

        Assert.assertEquals(linkedinSubmitLoginPage.unRegisteredEmail(),
                "Укажите действительный адрес эл. почты.",
                "Error message is wrong");

        Assert.assertTrue(linkedinSubmitLoginPage.emailFieldSubmitPage(),
                "Email field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.passwordFieldSubmitPage(),
                "Password field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.signInButtonPresence(),
                "Submit button is absent");


    }

    /**
     * @param email
     * @param password
     * Test for invalid login test
     */
    @Test(dataProvider = "invalidUnregisteredEmailDataProvider")
    public void negativeLoginTestInvalidLogin(String email, String password)
    {

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = linkedinLoginPage.submitPageLogin(email,password);


        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidLoginTextSubmitPage(),
                "Error message for incorrect login is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.getErrorTextSubmitPage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

        Assert.assertEquals(linkedinSubmitLoginPage.unRegisteredEmail(),
                "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "Wrong error message is displayed");

        Assert.assertTrue(linkedinSubmitLoginPage.emailFieldSubmitPage(),
                "Email field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.passwordFieldSubmitPage(),
                "Password field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.signInButtonPresence(),
                "Submit button is absent");


    }

    /**
     * @param email
     * @param password
     * Test for nonRegistered email
     */
    @Test(dataProvider = "invalidUnregisteredEmailDataProvider")
    public void negativeLoginTestNonRegisteredEmail(String email, String password)
    {

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = linkedinLoginPage.submitPageLogin(email,password);


        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidLoginTextSubmitPage(),
                "Error message for incorrect login is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.getErrorTextSubmitPage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

        Assert.assertTrue(linkedinSubmitLoginPage.emailFieldSubmitPage(),
                "Email field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.passwordFieldSubmitPage(),
                "Password field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.signInButtonPresence(),
                "Submit button is absent");


    }

    /**
     * @param email
     * @param password
     * Test for incorrect password testing
     */
    @Test(dataProvider = "invalidPasswordDataProvider")
    public void negativeLoginTestIncorrectPassword(String email, String password)
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);


        LinkedinSubmitLoginPage linkedinSubmitLoginPage = linkedinLoginPage.submitPageLogin(email,password);

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidPasswordSubmitPage(),
                "Error message for incorrect login is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.getErrorTextSubmitPage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

        Assert.assertEquals(linkedinSubmitLoginPage.invalidPasswordTextSubmitPage(),
                "Это неверный пароль. Повторите попытку или измените пароль.",
                "Wrong error message is displayed");

        Assert.assertTrue(linkedinSubmitLoginPage.emailFieldSubmitPage(),
                "Email field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.passwordFieldSubmitPage(),
                "Password field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.signInButtonPresence(),
                "Submit button is absent");

    }

    /**
     * @param email
     * @param password
     * Test for checking if one or both fields are empty
     */
    @Test(dataProvider = "emptyDataForEachFieldDataProvider")
    public void OneOrBothFieldsAreEmpty(String email, String password)
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login(email,password);

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login-Submit page is not loaded");

    }


}