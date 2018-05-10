import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample
{
    public static void main(String args[]) throws InterruptedException
    {
        System.out.println("Hello World!");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://google.com");

        WebElement search_field = webDriver.findElement(By.id("lst-ib"));
        search_field.sendKeys("Selenium");

        //sleep(1000);

        // Case_1. By clicking Enter button
        search_field.sendKeys(Keys.ENTER);

        // Case_2. By clicking on the "Google search" button
        //WebElement search_button = webDriver.findElement(By.xpath("//input[@type='button' and contains(@value,'Google')]"));
        //search_button.click();
        sleep (3000);

        //webDriver.close();

    //HomeWork 2.1
        //webDriver.findElement(By.xpath("//div[@class='srg']//div[@class='rc']"));
        //webDriver.findElement(By.xpath("//div[@class='srg']/div"));

//Variant_1
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults)
        {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium"))
            {
                System.out.println("SearchTerm found!!");
            }
            System.out.println(searchResult.getText());
        }

//Variant_2
        for (int i = 1; i<=10; i++)
        {
            WebElement searchResult = webDriver.findElement(By.xpath("//div[@class='srg']/div["+ i +"]"));
            String searchResultText = searchResult.getText();
            System.out.println(searchResult.getText());
            if (searchResultText.contains("Selenium"))
            {
                System.out.println("SearchTerm found!!");
            }
            System.out.println(searchResultText);
        }

    //HomeWork 2.2
    //Find each block one by one and print results for:
        // - title
        // - block
        // - text in block
    // in case search result = "Selenium" and != "Selenium"
        //Block_1
            WebElement searchResultBlock_1 = webDriver.findElement(By.xpath("//div[@class='srg']/div[1]"));
            String link_1 = webDriver.findElement(By.xpath("//div[@class='srg']/div[1]/descendant::a[1]")).getText();
            System.out.println(link_1);
            String textBlock_1 = webDriver.findElement(By.xpath("//div[@class='srg']/div[1]//span[@class='st']")).getText();
            System.out.println(textBlock_1);

            if (searchResultBlock_1.getText().contains("Selenium"))
            {
                System.out.println("Search term found in result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_2
            WebElement searchResultBlock_2 = webDriver.findElement(By.xpath("//div[@class='srg']/div[2]"));
            String link_2 = webDriver.findElement(By.xpath("//div[@class='srg']/div[2]/descendant::a[1]")).getText();
            System.out.println(link_2);
            String textBlock_2 = webDriver.findElement(By.xpath("//div[@class='srg']/div[2]//span[@class='st']")).getText();
            System.out.println(textBlock_2);

            if (searchResultBlock_2.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_3
            WebElement searchResultBlock_3 = webDriver.findElement(By.xpath("//div[@class='srg']/div[3]"));
            String link_3 = webDriver.findElement(By.xpath("//div[@class='srg']/div[3]/descendant::a[1]")).getText();
            System.out.println(link_3);
            String textBlock_3 = webDriver.findElement(By.xpath("//div[@class='srg']/div[3]//span[@class='st']")).getText();
            System.out.println(textBlock_3);

            if (searchResultBlock_3.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_4
            WebElement searchResultBlock_4 = webDriver.findElement(By.xpath("//div[@class='srg']/div[4]"));
            String link_4 = webDriver.findElement(By.xpath("//div[@class='srg']/div[4]/descendant::a[1]")).getText();
            System.out.println(link_4);
            String textBlock_4 = webDriver.findElement(By.xpath("//div[@class='srg']/div[4]//span[@class='st']")).getText();
            System.out.println(textBlock_4);

            if (searchResultBlock_4.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_5
            WebElement searchResultBlock_5 = webDriver.findElement(By.xpath("//div[@class='srg']/div[5]"));
            String link_5 = webDriver.findElement(By.xpath("//div[@class='srg']/div[5]/descendant::a[1]")).getText();
            System.out.println(link_5);
            String textBlock_5 = webDriver.findElement(By.xpath("//div[@class='srg']/div[5]//span[@class='st']")).getText();
            System.out.println(textBlock_5);

            if (searchResultBlock_5.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_6
            WebElement searchResultBlock_6 = webDriver.findElement(By.xpath("//div[@class='srg']/div[6]"));
            String link_6 = webDriver.findElement(By.xpath("//div[@class='srg']/div[6]/descendant::a[1]")).getText();
            System.out.println(link_6);
            String textBlock_6 = webDriver.findElement(By.xpath("//div[@class='srg']/div[6]//span[@class='st']")).getText();
            System.out.println(textBlock_6);

            if (searchResultBlock_6.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_7
            WebElement searchResultBlock_7 = webDriver.findElement(By.xpath("//div[@class='srg']/div[7]"));
            String link_7 = webDriver.findElement(By.xpath("//div[@class='srg']/div[7]/descendant::a[1]")).getText();
            System.out.println(link_7);
            String textBlock_7 = webDriver.findElement(By.xpath("//div[@class='srg']/div[7]//span[@class='st']")).getText();
            System.out.println(textBlock_7);

            if (searchResultBlock_7.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_8
            WebElement searchResultBlock_8 = webDriver.findElement(By.xpath("//div[@class='srg']/div[8]"));
            String link_8 = webDriver.findElement(By.xpath("//div[@class='srg']/div[8]/descendant::a[1]")).getText();
            System.out.println(link_8);
            String textBlock_8 = webDriver.findElement(By.xpath("//div[@class='srg']/div[8]//span[@class='st']")).getText();
            System.out.println(textBlock_8);

            if (searchResultBlock_8.getText().contains("Selenium"))
            {
            System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_9
            WebElement searchResultBlock_9 = webDriver.findElement(By.xpath("//div[@class='srg']/div[9]"));
            String link_9 = webDriver.findElement(By.xpath("//div[@class='srg']/div[9]/descendant::a[1]")).getText();
            System.out.println(link_9);
            String textBlock_9 = webDriver.findElement(By.xpath("//div[@class='srg']/div[9]//span[@class='st']")).getText();
            System.out.println(textBlock_9);

            if (searchResultBlock_9.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

        //Block_10
            WebElement searchResultBlock_10 = webDriver.findElement(By.xpath("//div[@class='srg']/div[10]"));
            String link_10 = webDriver.findElement(By.xpath("//div[@class='srg']/div[10]/descendant::a[1]")).getText();
            System.out.println(link_10);
            String textBlock_10 = webDriver.findElement(By.xpath("//div[@class='srg']/div[10]//span[@class='st']")).getText();
            System.out.println(textBlock_10);

            if (searchResultBlock_10.getText().contains("Selenium"))
            {
                System.out.println("Search term found is  result");
            }
            else
                System.out.println("Search term was not found in result");

            System.out.println();

    }

}
