package FugetronTest.FugetronTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;

public class GuruUITest extends BaseClass {
     private WebDriver driver;
    
     

     @BeforeClass
     public void setUp() {
    	 driver = new ChromeDriver();
    	 driver.get(url);
     }
     
     @Test(priority=1)
     public void verifyPageProperties() {
    	 Assert.assertEquals(url, driver.getCurrentUrl());
    	 Assert.assertEquals(landingPageTitle, driver.getTitle());

     }
    	 
     
     @Test(priority=2)
     public void choseCompany() {
    	 WebDriverWait wait1=new WebDriverWait(driver,10);    //EXPLICIT WAIT
    	 WebElement companyElement = driver.findElement(By.xpath(String.format("//table[@class='dataTable']//td//a[contains(text(),'%s')]", company.get(0))));
    	 wait1.until(ExpectedConditions.elementToBeClickable(companyElement));
    	 companyElement.click();
    	 Assert.assertEquals(homePageTitle, driver.getTitle());
    	 driver.navigate().back();
    	 Assert.assertEquals(url, driver.getCurrentUrl());

    	 
     }
    
     @Test(priority=3)
     public void verifyCurrentPrice() {

    	 WebElement currentPrice = driver.findElement(By.xpath(String.format(
    			 "//table[@class='dataTable']//td//a[contains(text(),'%s')]//following::td[3]", company.get(0))));
         try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}    	 
    	 String actualPrice = currentPrice.getText();
    	 
    	 Assert.assertEquals(Float.parseFloat(actualPrice), 900.0);
     }
     
     @AfterClass
     public void tearDown() {
    	 driver.quit();
     }
    	 
     
}
