package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

import static java.lang.Thread.sleep;

public class LinkedinBaseTest
{
    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void before() throws InterruptedException {
        webDriver = new FirefoxDriver();
    //  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(webDriver);
        sleep(3000);
    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }

}
