package com.ust.makemytrip;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MakeMyTrip {
	
	
	static WebDriver driver;
	
	@BeforeClass
	public void init() {
		
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
  @Test
  public void hotelBooking() throws Exception{
	  
	  //Open makemytrip.com  website
	  
	  driver.get("https://www.makemytrip.com/");
	  Thread.sleep(5000);
	  
	  driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
	  Thread.sleep(2000);
	   
	  //Sign in
	  
	  driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]/div/p")).click();
	  
	  WebElement id = driver.findElement(By.id("username"));
	  id.sendKeys("ABCD@gmail.com");
	  
	  driver.findElement(By.xpath("//span[text()='Continue']")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("password")).sendKeys("ABCD#123");
	  driver.findElement(By.xpath("//span[text()='Login']")).click();
	  Thread.sleep(3000);
	   
	  // Hotel Booking
	  
	  driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/a/span[1]")).click();
	  driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div/div/nav/ul/li[2]")).click();
	   
	  driver.findElement(By.xpath("//*[@id=\"city\"]")).click();
	  WebElement city =  driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']"));
	  city.sendKeys("Hyderabad");
	  Thread.sleep(2000);
	  city.sendKeys(Keys.ARROW_DOWN);
	  city.sendKeys(Keys.ENTER);
	   
	   Thread.sleep(5000);
	   driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	   Thread.sleep(3000);
	   
	   driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("//*[@id=\'checkin\']")).click();
	   driver.findElement(By.xpath("//div[@class=\'DayPicker-Day\'][contains(@aria-label,'Oct 20 2020')]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,' Oct 24 2020')]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\'guest\']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//li[@data-cy=\'adults-1\']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//button[@data-cy=\'submitGuest\']")).click();
	   driver.findElement(By.xpath("//button[@data-cy=\'submit\']")).click();
	   Thread.sleep(5000);
	   
	  
	   //Selecting Filters
      
	   WebElement slider;
       Thread.sleep(2000);
       slider=driver.findElement(By.xpath("//*[@id=\'hlistpg_fr_price_per_night\']/div[2]/div[2]/div/span[2]/div"));
       
       Actions action = new Actions(driver);
      
       action.moveToElement(slider).click().dragAndDropBy(slider, -50, 0).build().perform();
       
       //action.dragAndDropBy(slider, -50, 0).build().perform();
       //slider.click();
       
       Thread.sleep(5000);
	   
       WebElement star =  driver.findElement(By.xpath("//*[@id=\'hlistpg_fr_star_category\']/ul/li[2]/span[1]/label"));
 	   star.click();
      
	   driver.findElement(By.xpath("//label[@class=\'makeFlex column\']")).click();
	  
	   Thread.sleep(2000);
       driver.findElement(By.id("htl_id_seo_201006041053205988")).click();
	   
	   
	   String parent = driver.getWindowHandle();
	   Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while (it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	   
		driver.findElement(By.xpath("//*[@id=\'detpg_headerright_book_now\']")).click();
	   
	  // Traveller Information
		
	   Select sc = new Select(driver.findElement(By.id("title")));
	   sc.selectByVisibleText("Ms");
	   
	   Thread.sleep(1000);
	   WebElement name = driver.findElement(By.xpath("//*[@id=\'fName\']"));
	   driver.findElement(By.className("close")).click();
	   Thread.sleep(3000);
	   name.sendKeys("Bharathi");
	   driver.findElement(By.xpath("//*[@id=\'lName\']")).sendKeys("Ungarala");
	   
	  // WebElement email = driver.findElement(By.id("email"));
	  // Thread.sleep(2000);
	  // email.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "radha@gmail.com");
	   
	   
	  // WebElement pno = driver.findElement(By.id("mNo"));
	  // Thread.sleep(2000);
	  // pno.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "1234567898");
	   
	   
	   driver.findElement(By.xpath("//label[@for=\"104\"]")).click();
	   driver.findElement(By.id("109")).sendKeys("NO");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/a/div")).click();
	   Thread.sleep(2000);
	   
	   //Payment Details
	  
	   driver.findElement(By.xpath("//*[@id=\'CC\']/span[2]")).click();
	   driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys("1234567891234567");
	   driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("radha");
	   Thread.sleep(2000);
	 
	   Select mn = new Select(driver.findElement(By.id("PAYMENT_expiryMonth")));
	   mn.selectByValue("12");
	  
	   Select year = new Select(driver.findElement(By.id("PAYMENT_expiryYear")));
	   year.selectByValue("2024");
	  
	   Thread.sleep(2000);
	   driver.findElement(By.id("PAYMENT_cvv")).sendKeys("000");
	  
	   Thread.sleep(3000);
	  
	   Select cn =new Select(driver.findElement(By.id("PAYMENT_billingCountry")));
	   cn.selectByVisibleText("India");
	  
	   Thread.sleep(1000);
	  
	   driver.findElement(By.id("PAYMENT_billingAddress")).sendKeys("Hyderabad");
	  
	   driver.findElement(By.id("PAYMENT_billingCity")).sendKeys("Hyderabad");
	  
	   driver.findElement(By.id("PAYMENT_billingPin")).sendKeys("51203");
	  
	   driver.findElement(By.id("PAYMENT_billingState")).sendKeys("Telangana");
	   Thread.sleep(2000);
	  
	   driver.findElement(By.xpath("//*[@id=\'widgetPayBtn\']/span")).click();
	      
  
  }

       @AfterMethod
        public void captureResult() throws Exception {
	  
	      File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String imagepath = System.getProperty("user.dir")+"/screenshot/"+"PaymentErrorImage.png";
		  File destFile = new File(imagepath);
		  FileUtils.copyFile(srcFile,destFile);
		  
		  
		  }

  @AfterClass
  public void close() {
	  
	  driver.quit();
  }
  }
	  


