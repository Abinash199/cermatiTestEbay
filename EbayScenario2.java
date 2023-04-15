package Webapps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayScenario2 {
	public static void main(String[] args) throws InterruptedException {
    	
    	
        // set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\navee\\\\OneDrive\\\\Desktop\\\\New Chrome driver\\\\chromedriver_win32 (1)\\\\chromedriver.exe\\\\");

        // create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();
        
        // navigate to eBay
        driver.get("https://www.ebay.com/");
        
        driver.manage().window().maximize();
        

                // locate the search bar and enter the search string
                WebElement searchBox = driver.findElement(By.id("gh-ac"));
                searchBox.sendKeys("MacBook");
                
                // click the search button
                WebElement searchButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
          
                searchButton.click();

                // locate the search category dropdown and select "Computers/Tablets & Networking"
                WebElement categoryDropdown = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
                Select selectCategory = new Select(categoryDropdown);
                selectCategory.selectByVisibleText("Computers/Tablets & Networking");
                
                WebElement Compsearch = driver.findElement(By.xpath("//input[@id='gh-btn']"));
                Thread.sleep(2000);
                Compsearch.click();
                
                JavascriptExecutor j = (JavascriptExecutor) driver;           
                j.executeScript("return document.readyState").toString().equals("complete");
                // get the current URL
                String s = driver.getCurrentUrl();
                // checking condition if the URL is loaded
                
                if (s.equals("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2334524.m570.l1313&_nkw=MacBook&_sacat=58058&LH_TitleDesc=0")) {
                   System.out.println("Page Loaded");
                   System.out.println("Current Url: " + s);
                }
                else {
                   System.out.println("Page did not load");
                }
                
                WebElement matchingResult= driver.findElement(By.xpath("//span[normalize-space()='MacBook']"));
                List<WebElement> listResult= matchingResult.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div"));
                System.out.println(listResult.size());
                
                     for(WebElement results: listResult)
                       {
                         String value= results.getText();
                         System.out.println(value);
                       }     
                
        driver.quit();
  
    
	}
	
	}

