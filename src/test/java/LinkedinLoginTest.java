import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest
{
    @Test
    public void successfulLoginTest() throws InterruptedException
    {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

    //Assert.assertEquals("a","b", "Probably 'a' is not equal to 'b'");

    String actualLoginPageTitle = webDriver.getTitle();

    //Assert for title
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

    //Assert for URL
        //String URL = webDriver.getCurrentUrl();
        //Assert.assertEquals(URL,
                //"https://www.linkedin.com/",
                //"Wrong URL");

        Assert.assertEquals(webDriver.getCurrentUrl(),
            "https://linkedin.com/",
            "Incorrect URL");

    //Assert for login field presence
        WebElement loginField = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        Assert.assertTrue(loginField.isDisplayed(),
                "Login field is absent");

    //Assert for password field presence
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@class='login-password']"));
        Assert.assertTrue(passwordField.isDisplayed(),
                "Password field is absent");

    //Assert for OK button presence
        WebElement okButton = webDriver.findElement(By.xpath("//input[@class='login submit-button']"));
        Assert.assertTrue(okButton.isDisplayed(),
                "OK button is absent");

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
        Assert.assertEquals(loggedURL,
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


}