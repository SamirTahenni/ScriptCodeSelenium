package Test_Cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Text_exo_imdb
{
	
	WebDriver driver = new ChromeDriver();
	WebElement listeDeroulante;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		

	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("bonjour");
	  driver.quit();  
	  
  }
  @Test
  public void test_exo_imdb() throws Exception
  {
	  driver.navigate().to("https://www.imdb.com/"); 
	  driver.findElement(By.xpath("(//*[@id ='iconContext-arrow-drop-down'])[1]")).click();
	  driver.findElement(By.xpath("//a[@class='ipc-list__item searchCatSelector__item']")).click();
	  driver.findElement(By.linkText("Advanced Title Search")).click();
	  driver.findElement(By.id("title_type-1")).click();
	  driver.findElement(By.id("title_type-2")).click();
	  driver.findElement(By.name("release_date-min")).sendKeys("2000");
	  driver.findElement(By.name("release_date-max")).sendKeys("2023");
	  //Select(driver.findElement(By.name("user_rating-min")).select_by_visible_text("1.0")
	  
	  WebElement rating_min=driver.findElement(By.name("user_rating-min"));
	  Select select =new Select(rating_min);
	  select.selectByVisibleText("1.0");
	  Thread.sleep(4000);
	  
	  WebElement rating_max=driver.findElement(By.name("user_rating-max"));
	  Select select1 =new Select(rating_max);
	  select1.selectByVisibleText("10");
	  Thread.sleep(4000);
	  driver.findElement(By.id("groups-4")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.id("colors-1")).click();
	  Thread.sleep(4000);
	  JavascriptExecutor scroll=(JavascriptExecutor) driver;
	  scroll.executeAsyncScript("Window.ScrollBy(0,500);");
	  
	  
	  //WebElement Language= wait.until(ExpectedConditions.elementToBeClickable(By.name("language")));
	  
	  WebElement Language= driver.findElement(By.name("languages"));
	  Select select2 =new Select(Language);
	  select2.selectByIndex(80);
	  
	  
  }
  

}
