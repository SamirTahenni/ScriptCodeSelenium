package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExerciceOpenC2 {

	
	private static final String Theard = null;
	//WebDriver driver=null;
	WebDriver driver = new ChromeDriver();
	@BeforeClass
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
		
		driver.findElement(By.name("username")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");
	Theard.sleep(4000);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	}
	@AfterClass
	public void afterMethod() {
		
		driver.quit();
	}

	@Test
	public void ActionsMethod()
	{
		System.out.println("Test");
		
	}

	
	

}
