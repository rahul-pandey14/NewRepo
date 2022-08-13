package seleniumBasics.handlingDropdown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropdown {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver
				.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select sel = new Select(staticDropdown);
		Thread.sleep(3000);
		sel.selectByValue("USD");
		Thread.sleep(3000);
		sel.selectByIndex(0);
		Thread.sleep(3000);
		sel.selectByVisibleText("AED");
		System.out.println(sel.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		driver.close();
	}

}
