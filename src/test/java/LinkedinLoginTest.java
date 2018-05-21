import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest
{
    WebDriver webDriver;

    @BeforeMethod
    public void before()
    {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.linkedin.com/");
    }


    @Test
    public void successfulLoginTest()
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is not displayed");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign in button is absent");

        Assert.assertEquals(linkedinLoginPage.getCurrentURLLoginPage(),
                "https://www.linkedin.com/",
                "Login page URL is wrong");

        Assert.assertEquals(linkedinLoginPage.getCurrentTitleLoginPage(),
                "https://www.linkedin.com/",
                "Login page title is wrong");

        linkedinLoginPage.login("scheh@adyax.com", "Password0123");
        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

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

    @Test
    public void negativeLoginTestIncorrectLogin() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign is button is absent");

        linkedinLoginPage.login("schehadyax", "Password0123");

        sleep(3000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidLoginTextSubmitPage(),
                "Error message is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.errorTextSubmitPage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

        Assert.assertTrue(linkedinSubmitLoginPage.emailFieldSubmitPage(),
                "Email field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.passwordFieldSubmitPage(),
                "Password field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.signInButtonPresence(),
                "Submit button is absent");


    }

    @Test
    public void negativeLoginTestInvalidLogin() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("s@adyax.com", "Password0123");

        sleep(2000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidLoginTextSubmitPage(),
                "Error message for incorrect login is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.errorTextSubmitPage(),
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

    @Test
    public void negativeLoginTestNonRegisteredEmail() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("s@adyax.com", "Password0123");

        sleep(2000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidLoginTextSubmitPage(),
                "Error message for incorrect login is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.errorTextSubmitPage(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

        Assert.assertTrue(linkedinSubmitLoginPage.emailFieldSubmitPage(),
                "Email field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.passwordFieldSubmitPage(),
                "Password field is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.signInButtonPresence(),
                "Submit button is absent");


    }

    @Test
    public void negativeLoginTestIncorrectPassword() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("scheh@adyax.com", "Password");

        sleep(2000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.errorBlockSubmitPage(),
                "Error message block is absent");

        Assert.assertTrue(linkedinSubmitLoginPage.invalidPasswordSubmitPage(),
                "Error message for incorrect login is absent");

        Assert.assertEquals(linkedinSubmitLoginPage.errorTextSubmitPage(),
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

    @Test
    public void BothFieldsAreEmpty()
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("", "");

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign is button is absent");

    }

    @Test
    public void emailFieldIsEmpty()
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("", "Password0123");

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign is button is absent");

    }

    @Test
    public void passwordFieldIsEmpty()
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("scheh@adyax.com", "");

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign is button is absent");

    }


    @AfterMethod
    public void after()
    {
        webDriver.close();
    }

}