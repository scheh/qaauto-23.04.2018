package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for Search results
 */
public class LinkedinSearchResults extends LinkedinBasePage
{
    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//li[contains(@class,'search-result search-result__occluded')]")
    private List<WebElement> searchResultElements;

    /**
     * @param webDriver
     * constructor for webdriver search results
     */
    public LinkedinSearchResults(WebDriver webDriver)
    {
        super(webDriver);
        //waitUntilElementsVisible(searchResultsCount, 5);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return searchResultsCount
     * Method checking page is loaded
     */
    public boolean isPageLoaded()
    {
        waitUntilElementsVisible(searchResultsCount, 10);
        return searchResultsCount.isDisplayed();
    }

    /**
     * @return search results
     * Method for getting search results
     */
    public List<String> getSearchResults()
    {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements)
        {
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}

