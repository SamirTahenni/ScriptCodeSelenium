package Test_Cases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExerciceOpen {
	@Test
	public void test_End_to_End() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		// la prochaine etape en va login
		WebElement user = driver.findElement(By.name("username"));
		user.clear();
		user.sendKeys("demo");

		WebElement pass = driver.findElement(By.name("password"));
		pass.clear();
		pass.sendKeys("demo");
		driver.findElement(By.xpath("//button[text()=\" Login\"]")).click();
		
		//prendre un Screenshot 
		
		WebElement btn_modal=driver.findElement(By.cssSelector(".btn-close"));
		File Source=btn_modal.getScreenshotAs(OutputType.FILE);
		File destination =new File("C:\\Users\\Samir\\Desktop\\java laboratoire2\\Project3\\src\\test\\java\\Test_Cases\\boutton.png");
		FileUtils.copyFile(Source, destination);
		Thread.sleep(4000);
		//prendre un Screenshot de toute la page
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Source_page=btn_modal.getScreenshotAs(OutputType.FILE);
		File destination_page =new File("C:\\Users\\Samir\\Desktop\\java laboratoire2\\Project3\\src\\test\\java\\Test_Cases\\page.png");
		FileUtils.copyFile(Source_page, destination_page);
		
		// Gérer la modal

		if (driver.findElement(By.cssSelector(".btn-close")).isDisplayed());
		driver.findElement(By.cssSelector(".btn-close")).click();

		// Valider l'acces
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()= \"Logout\"]")).isDisplayed());

		// Gérer les clients
		driver.findElement(By.xpath("//a[@href=\"#collapse-5\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//ul[@id=\"collapse-5\"]/li[1]")).click();
		Thread.sleep(4000);

		String text = driver.findElement(By.xpath("(//div[@class='col-sm-6 text-end'])[1]")).getText();
		System.out.println(text);

		int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		String S = "25";
		int h = Integer.parseInt(S) + 10;
		System.out.println(h);

		System.out.println(total_pages);
		// System.out.println(driver.findElement(By.xpath("(//div[@class='col-sm-6
		// text-end'])[1]")).getText());

		// Parcourir toutes les pages et afficher le contenue
		for (int i = 1; i < 6; i++) {
			if (total_pages >= 1) {
				WebElement page_numbre = driver
						.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + i + "]"));
				System.out.println("le numéro de page est " + page_numbre.getText());
				page_numbre.click();
				Thread.sleep(4000);

			}
			// Récupere les valeur du client et mail et statut
			int nombre_lignes = driver
					.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]/tbody/tr")).size();
			System.out.println("nombre de ligne du tableau est :" + nombre_lignes);
			for (int j = 1; j < nombre_lignes; j++) {
				String nom_client = driver
						.findElement(By
								.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + j + "]/td[2]"))
						.getText();
				String email_client = driver
						.findElement(By
								.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + j + "]/td[3]"))
						.getText();
				String statut_client = driver
						.findElement(By
								.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + j + "]/td[5]"))
						.getText();
				System.out.println(nom_client + "------" + email_client + "------" + statut_client);

			}
		}
		driver.quit();
	}
}
