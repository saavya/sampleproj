package sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Satya\\eclipse-workspace\\Chrome_Driver\\Version_73\\chromedriver.exe");
		driver = new ChromeDriver();
			

	}

	@Test(priority = 1)
	public void openTargetBrowser() {
		driver.get("https://www.target.com/");
		
	}
	

	@Test(priority = 2)
	public void clickOnRegistries() {

		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/ul/li[1]/a")).click();
	}
	
	//@Test(priority = 3)
	public void emptyInputValidationError() throws InterruptedException {
		driver.findElement(By.id("registrySearchFirstName")).sendKeys("");
		Thread.sleep(1000);
		  driver.findElement(By.id("registrySearchLastName")).sendKeys("");
		  Thread.sleep(1000);
		  driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/div[2]/button"))
					.click();
		  
	
		  SoftAssert softAssert=new SoftAssert();
		  String ActualErrorMessage= driver.findElement(By.id("registrySearchFirstName--ErrorMessage")).getText();
		  String ActualErrorMessage2= driver.findElement(By.id("registrySearchLastName--ErrorMessage")).getText();
		  
		 softAssert.assertEquals(ActualErrorMessage, "Please enter a first name.");
		  
		  
		  softAssert.assertEquals(ActualErrorMessage2, "Please enter a last name.");
		  softAssert.assertAll();
		  
	
}
	
	//@Test(priority = 4)
	public void validFirstName() throws InterruptedException {
		
		driver.findElement(By.id("registrySearchFirstName")).sendKeys("sara");
		Thread.sleep(1000);
		  driver.findElement(By.id("registrySearchLastName")).sendKeys("");
		  Thread.sleep(1000);
		  driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/div[2]/button"))
					.click();
		  SoftAssert softAssert=new SoftAssert();
		  String ActualErrorMessage= driver.findElement(By.id("registrySearchLastName--ErrorMessage")).getText();
		  softAssert.assertEquals(ActualErrorMessage, "Please enter a last name.");
		  softAssert.assertAll();
	
		// Assert.assertEquals(driver.findElement(By.id("registrySearchLastName--ErrorMessage")).getText(), " Please enter a last name.");
		  
		driver.findElement(By.id("registrySearchFirstName")).clear();
		
		  Thread.sleep(1000);
		  
	
}

	//@Test(priority = 5)
	public void testSearchForTooManyResults() throws InterruptedException {
	Thread.sleep(1000);
		driver.findElement(By.id("registrySearchFirstName")).sendKeys("sa");
		driver.findElement(By.id("registrySearchLastName")).sendKeys("la");

		driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/div[2]/button"))
				.click();
		
		Thread.sleep(3000);
		
		//Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[3]/div[1]/span/span")).getText(), "Your search returned too many results. Please select a registry type and enter the registrant’s full name.");
	
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[3]/div[1]/span/span"));
		System.out.println("msg ::: " + msg + " \n text " + msg.getText());
		String text = msg.getText();
		String expectedText = "Your search returned too many results. Please select a registry type and enter the registrant’s full name.";
		Assert.assertEquals(text,expectedText);
		Thread.sleep(1000);
		driver.findElement(By.id("registrySearchFirstName")).clear();
		driver.findElement(By.id("registrySearchLastName")).clear();
		Thread.sleep(1000);
}
	
	@Test(priority = 6)
	public void noSuchNameExists() throws InterruptedException {
		driver.findElement(By.id("registrySearchFirstName")).sendKeys("@@");
		Thread.sleep(1000);
		  driver.findElement(By.id("registrySearchLastName")).sendKeys("@@");
		  Thread.sleep(1000);
		  driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/div[2]/button"))
					.click();
		/*
		 * WebElement msg = driver.findElement(By.xpath(
		 * "//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[3]/div[1]/span/span"
		 * )); System.out.println("msg ::: " + msg + " \n text " + msg.getText());
		 * String text = msg.getText(); String expectedText =
		 * "Sorry, we didn’t find anyone by that name.";
		 * Assert.assertEquals(text,expectedText);
		 */
			
			driver.findElement(By.id("registrySearchFirstName")).clear();
			driver.findElement(By.id("registrySearchLastName")).clear();
		  
	}
		

	//@Test(priority = 7)
	public void validSearch() throws InterruptedException {
		driver.findElement(By.id("registrySearchFirstName")).sendKeys("sara");
		Thread.sleep(1000);
		  driver.findElement(By.id("registrySearchLastName")).sendKeys("larra");
		  Thread.sleep(1000);
		  driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/div[2]/button"))
					.click();
			 String pageTitle = driver.getTitle();
			 
			 System.out.println("pageTitle ::: "+pageTitle);
			
			Assert.assertEquals("Gift Registry & Lists : Target",pageTitle);
			System.out.println(pageTitle);
			Thread.sleep(1000);
		  
	}
	
	
}
