package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class first {
	
	@Test
	public void negativeLogin1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("http://magento.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a")).click();
		driver.findElement(By.id("email")).sendKeys("vijaykarthik17@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password123");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"),"Invalid login or password."));
		driver.quit();
	}
}
