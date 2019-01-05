package com.ibm.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testAtoZGrocery_TC001 {
	public static String driverPath = "C://Users//snigdha//Downloads//chromedriver_win32//";
	public static WebDriver driver;
	String username = "demo@atozgroceries.com";
	String passWord = "456789";

	@BeforeTest
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testTC001() throws InterruptedException {

		driver.get("https://atozgroceries.com/admin/");
		WebElement userid = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/div/input"));
		userid.sendKeys(username);

		WebElement passWd = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/div/input"));
		passWd.sendKeys(passWord);

		WebElement logInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button"));
		logInBtn.click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);

		for (int i = 1; i <= 10; i++) {
			WebElement addTabLink = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/ol/li[1]/a/i"));
			addTabLink.click();

			WebElement tabName = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div/div/div[2]/div[1]/div/input"));
			tabName.sendKeys("DemoTab" + i + "AD");
			WebElement sortOrder = driver
					.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div/div/div[2]/div[2]/div/input"));
			sortOrder.sendKeys(Integer.toString(i));
			Select status = new Select(driver.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div/div/div[2]/div[3]/div/select")));
			status.selectByVisibleText("Enabled");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[1]/button")).click();
		}
		Thread.sleep(4000);
		Select entries = new Select(driver.findElement(
				By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/label/select")));
		entries.selectByVisibleText("All");
		Thread.sleep(2000);
		entries.selectByVisibleText("10");
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			System.out.println("Closing chrome browser");
			//driver.quit();
		}
	}
}
