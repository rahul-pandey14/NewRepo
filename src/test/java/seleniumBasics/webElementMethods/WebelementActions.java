package seleniumBasics.webElementMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebelementActions {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkboxes.size());
		WebElement selectedCheckbox = driver
				.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
		System.out.println(selectedCheckbox.isSelected());
		System.out.println(selectedCheckbox.getText());
		System.out.println(
				driver.findElement(By.xpath("//input[@type='checkbox']"))
						.getTagName());
		Thread.sleep(5000);
		selectedCheckbox.click();
		Thread.sleep(2000);

		driver.close();

	}

}
