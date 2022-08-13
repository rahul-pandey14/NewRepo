package seleniumBasics.handlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"))
				.click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath(
				"//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BHO']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> value = driver
				.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement options : value) {

			if (options.getText().equalsIgnoreCase("Indonesia")) {
				options.click();
			}

		}
		{

			Thread.sleep(3000);
		}

		driver.close();
	}
}
