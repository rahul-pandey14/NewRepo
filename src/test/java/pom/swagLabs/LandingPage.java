package pom.swagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	@FindBy(id = "user-name")
	private static WebElement userNameTxtBx;
	@FindBy(id = "password")
	private static WebElement pwdTxtBx;
	@FindBy(id = "login-button")
	private static WebElement loginBtn;
	@FindBy(xpath = "//span[@class='title']")
	private static WebElement product;

	public LandingPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void loginWithValidCredential(String userName, String password) {

		userNameTxtBx.sendKeys(userName);
		pwdTxtBx.sendKeys(password);
		loginBtn.click();
	}

	public String verifyProductName() {
		String productTitle = product.getText();
		return productTitle;
	}

}
