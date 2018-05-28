import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
                {"cheh@adyax.com", "Passs"},
                {"233@i.ua", "Passwordeer"},
                {"come@bigmir.net", "Oofjnfnff"}

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


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password)
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


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
        //LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);


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

    @Test(dataProvider = "invalidIncorrectEmailDataProvider")
    public void negativeLoginTestIncorrectLogin(String email, String password) throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertTrue(linkedinLoginPage.isEmailFieldDisplayed(),
                "Email field is absent");

        Assert.assertTrue(linkedinLoginPage.isPasswordFieldDisplayed(),
                "Password field is absent");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign is button is absent");

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = linkedinLoginPage.submitPageLogin(email,password);

        sleep(3000);

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

    @Test(dataProvider = "invalidUnregisteredEmailDataProvider")
    public void negativeLoginTestInvalidLogin(String email, String password) throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login(email, password);

        sleep(2000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

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

    @Test(dataProvider = "invalidUnregisteredEmailDataProvider")
    public void negativeLoginTestNonRegisteredEmail(String email, String password) throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login(email, password);

        sleep(3000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

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

    @Test(dataProvider = "invalidPasswordDataProvider")
    public void negativeLoginTestIncorrectPassword(String email, String password) throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login(email, password);

        sleep(2000);

        LinkedinSubmitLoginPage linkedinSubmitLoginPage = new LinkedinSubmitLoginPage(webDriver);

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

    @Test(dataProvider = "emptyDataForEachFieldDataProvider")
    public void OneOrBothFieldsAreEmpty(String email, String password)
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login(email,password);

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