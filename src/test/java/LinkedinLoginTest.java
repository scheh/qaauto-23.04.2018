import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

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
    public void successfulLoginTest() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        //Assert.assertEquals("a","b", "Probably 'a' is not equal to 'b'");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign is button is not displayed");

        linkedinLoginPage.login("scheh@adyax.com", "Password0123");
        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        //Assert for title
        Assert.assertEquals(linkedinHomePage.getCurrentURL(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong");

        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page title is wrong.");


        //To refact!!!

        //Assert for login field presence
        WebElement loginField = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        Assert.assertTrue(loginField.isDisplayed(),
                "Login field is absent");

        //Assert for password field presence
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@class='login-password']"));
        Assert.assertTrue(passwordField.isDisplayed(),
                "Password field is absent");

    }

    @Test
    public void negativeLoginTest() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        linkedinLoginPage.isSignInButtonDisplayed();
        linkedinLoginPage.login("schehadyax", "Password0");


        sleep(3000);

        String currentPageURL = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageURL,
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page URL submit is wrong");

        Assert.assertEquals(currentPageTitle,
                "Войти в LinkedIn",
                "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error message text displayed.");

    }
    @Test
    public void negativeLoginTest1() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.isSignInButtonDisplayed();
        linkedinLoginPage.login("scheh@adyax.com", "Password0123");

        sleep(3000);

        String currentPageURL = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageURL,
                "https://www.linkedin.com/feed/",
                "Login-Submit page URL submit is wrong");

        Assert.assertEquals(currentPageTitle,
                "LinkedIn",
                "Login-Submit page Title is wrong");


        //Assert for login field presence
        WebElement loginField = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        Assert.assertTrue(loginField.isDisplayed(),
                "Login field is absent");

        //Assert for password field presence
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@class='login-password']"));
        Assert.assertTrue(passwordField.isDisplayed(),
                "Password field is absent");

    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }


}
    // @Test
    //public void passwordIsAbsent()
    //{
    //Negative cases
    /*    loginField.sendKeys("scheh@adyax.com");
        passwordField.clear();
        okButton.click();

        Assert.assertTrue(loginField.isDisplayed(),
                "Login field is absent");
        Assert.assertTrue(passwordField.isDisplayed(),
                "Password field is absent");
        Assert.assertTrue(okButton.isDisplayed(),
                "Ok button is absent");

    //Case2
        loginField.clear();
        passwordField.sendKeys("Password");
        okButton.click();

        Assert.assertTrue(loginField.isDisplayed(),
                "Login field is absent");
        Assert.assertTrue(passwordField.isDisplayed(),
                "Password field is absent");
        Assert.assertTrue(okButton.isDisplayed(),
                "Login button is absent");

    //Case3
        loginField.sendKeys("schehschehscheh");
        passwordField.sendKeys("password");
        okButton.click();

        sleep(3000);

        WebElement errorMessage1 = webDriver.findElement(By.xpath("//strong"));
        Assert.assertTrue(errorMessage1.isDisplayed(),
                "Message is absent");

        WebElement errorMessage2 = webDriver.findElement(By.xpath("//*[@id='session_key-login-error']"));
        Assert.assertTrue(errorMessage2.isDisplayed(),
                "Message is absent");

        WebElement errorText1 = webDriver.findElement(By.xpath("//*[@id='control_gen_1']/p/strong"));
        Assert.assertEquals(errorText1.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error message is wrong");

        WebElement errorText2 = webDriver.findElement(By.xpath("//*[@id='session_key-login-error']"));
        Assert.assertEquals(errorText2.getText(),
                "Укажите действительный адрес эл. почты.",
                "Error message is wrong");

        sleep(3000);

    //Case4
        WebElement emailField = webDriver.findElement(By.xpath("//*[@id='session_key-login']"));
        WebElement passField = webDriver.findElement(By.xpath("//*[@id='session_password-login']"));
        WebElement signInButton = webDriver.findElement(By.id("btn-primary"));

        emailField.clear();
        passField.clear();

        emailField.sendKeys("scheh@adyax.com");
        passField.sendKeys("123456");
        signInButton.click();

        sleep(3000);

        WebElement errorMessage3 = webDriver.findElement(By.xpath("//strong"));
        Assert.assertTrue(errorMessage3.isDisplayed(),
                "Error message is absent");

        Assert.assertEquals(errorText1.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error message is wrong");

        Assert.assertEquals(errorText2.getText(),
                "Укажите действительный адрес эл. почты.",
                "Error message is wrong");

    //Case5
        emailField.sendKeys("scheeeeehh@ady.ua");
        passField.sendKeys("Password0123");
        signInButton.click();
        sleep(3000);

        Assert.assertTrue(errorMessage1.isDisplayed(),
                "Error message is absent");

        Assert.assertTrue(errorMessage2.isDisplayed(),
                "Error message is absent");

        Assert.assertEquals(errorText1.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error message is wrong");

        Assert.assertEquals(errorText2.getText(),
                "Укажите действительный адрес эл. почты.",
                "Error message is wrong");

    //Case6
        emailField.clear();
        passField.clear();
        signInButton.click();

        Assert.assertTrue(errorMessage1.isDisplayed());

        Assert.assertEquals(errorText1.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error message is wrong");

        Assert.assertEquals(errorText2.getText(),
                "Укажите действительный адрес эл. почты.",
                "Error message is wrong");


    //Log in process
        loginField.sendKeys("sths@ukr.net");
        passwordField.sendKeys("*********");

//Variant_1
        //WebElement okButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));
        //submit_button.sendKeys(Keys.ENTER);

//Variant_2
        okButton.click();
        sleep(3000);

    //Assert for correct Title
        //Assert.assertEquals(webDriver.getTitle(),
                //"LinkedIn",
                //"Page Title is Wrong");

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Title is Wrong");

        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle);

    //Assert for correct URL
        String loggedURL = webDriver.getCurrentUrl();
        assertEquals(loggedURL,
                "https://www.linkedin.com/feed/",
                "URL Incorrect" );

    //Assert for HomePage element presence
        WebElement homepageIcon = webDriver.findElement(By.xpath("//*[@class='nav-item__icon']"));
        Assert.assertTrue(homepageIcon.isDisplayed(),
                "HomePage icon is absent");

    //Assert for MyNetwork element presence
        WebElement mynetworkIcon = webDriver.findElement(By.xpath("//span[@id='mynetwork-tab-icon']"));
        Assert.assertTrue(mynetworkIcon.isDisplayed(),
                "My Network icon is absent");

    //Assert for jobs element presence
        WebElement jobsIcon = webDriver.findElement(By.xpath("//span[@id='jobs-tab-icon']"));
        Assert.assertTrue(jobsIcon.isDisplayed(),
                "Jobs icon is absent");

        //webDriver.close();
    }


}*/