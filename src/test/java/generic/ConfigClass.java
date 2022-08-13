package generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigClass {

	protected static WebDriver driver;

	@BeforeMethod
	public static WebDriver lancuhBrowser() throws IOException {

		String browserName = PropertyLoader.getPropertyValue("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else

			System.out.println("no browser found");

		return driver;
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
