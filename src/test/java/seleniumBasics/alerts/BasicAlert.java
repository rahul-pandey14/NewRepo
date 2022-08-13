package seleniumBasics.alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAlert {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/basic_auth']")).click();
		Thread.sleep(4000);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		// driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();
		// System.out.println("clicked");
		// driver.findElement(By.id("timerAlertButton")).click();
		// Thread.sleep(7000);
		// driver.switchTo().alert().accept();
		// System.out.println("clicked again");
		// Thread.sleep(3000);
		//
		// driver.findElement(By.id("confirmButton")).click();
		// String alert = driver.switchTo().alert().getText();
		// System.out.println(driver.switchTo().alert().getText());
		//
		// Assert.assertEquals(alert,
		// "Do you confirm action?");
		// driver.switchTo().alert().dismiss();
		// System.out.println("Select DismissS");
		// Thread.sleep(2000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,500)");
		// driver.findElement(By.id("promtButton")).click();
		// Thread.sleep(3000);
		// driver.switchTo().alert().sendKeys("Rahul");
		// Thread.sleep(10000);
		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();
		// System.out.println("ok");

		// driver.close();

	}
}
