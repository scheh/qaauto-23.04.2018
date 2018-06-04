package page;

import org.openqa.selenium.WebDriver;

public abstract class LinkedinBasePage
{
    protected WebDriver webDriver;

    public LinkedinBasePage(WebDriver webDriver)

    {
        this.webDriver = webDriver;
    }

    public String getCurrentURLHomePage() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitleHomePage() {
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded();

    

}
