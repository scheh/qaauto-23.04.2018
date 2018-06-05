package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResults;

import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest
{
    @Test
    public void basicSearchTest()
    {
        String searchTerm = "hr";

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login("scheh@adyax.com", "Password123");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");

        LinkedinSearchResults linkedinSearchResults = linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchResults.isPageLoaded(),
                "SearchResults page is not loaded.");

        List<String> searchResultsList = linkedinSearchResults.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 10,
                "Count of search result item is wrong");

        for (String searchResult:searchResultsList)
        {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+searchTerm+" was not found in: \n"+searchResult);
        }

    }
}
