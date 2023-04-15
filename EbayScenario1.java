package Webapps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayScenario1 {
    private static WebDriverWait wait;
    

	public static void main(String[] args) {
        // Set the driver path and instantiate a ChromeDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\navee\\OneDrive\\Desktop\\New Chrome driver\\chromedriver_win32 (1)\\chromedriver.exe\\");
        WebDriver driver = new ChromeDriver();
      
        // Navigate to ebay.com
        driver.get("https://www.ebay.com/");
       
        driver.manage().window().maximize();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        WebElement shopbycategory =driver.findElement(By.xpath("//button[@id='gh-shop-a']"));
        shopbycategory.click();
        
        WebElement Electronics =driver.findElement(By.xpath("//a[@title='Your shopping destination for the best selection and value in electronics and accessories']//i[@class='chevron-right']"));
        Electronics.click(); 

       wait = new WebDriverWait(driver, 10);
       WebElement CellPhonesAccessories =driver.findElement(By.xpath("//*[@id=\"s0-16-12-0-1[0]-0-0-27[1]-0-toggle-button\"]"));
       CellPhonesAccessories.click();
       
       for(int i=0;i<10;i++) {
           js.executeScript("window.scrollBy(0,13)");
           try {
              Thread.sleep(500);
           } catch (InterruptedException a) {
              a.printStackTrace();
           }
        }
       
       wait = new WebDriverWait(driver, 10);
       WebElement CellPhoneandSmartPhones =driver.findElement(By.xpath("//*[@id=\"s0-16-12-0-1[0]-0-0-27[1]-0\"]/ul/li[4]/a"));
       CellPhoneandSmartPhones.click();
 
       WebElement SeeAll =driver.findElement(By.cssSelector(".btn.btn--small[data-marko='{\"onclick\":\"handleSeeAllBtn s0-27-9-0-1[0]-0-1[0]-0 false\"}']"));
       SeeAll.click();
       
       //switching to iframe overlay see all
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".x-overlay__container")));

     
     WebElement screenSizeFilter = driver.findElement(By.cssSelector("body > div:nth-child(47) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(7)"));
     WebElement priceFilter = driver.findElement(By.xpath("//div[@id='c3-mainPanel-price']"));
     WebElement itemLocationFilter = driver.findElement(By.xpath("//div[@id='c3-mainPanel-location']"));
       screenSizeFilter.click();
       priceFilter.click();
       itemLocationFilter.click();

       
       WebElement applyButton = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
      applyButton.click();
      WebElement filterTags = driver.findElement(By.cssSelector(".x-tray__count"));
      assert filterTags.isDisplayed();

      
       driver.quit();
	}
}
