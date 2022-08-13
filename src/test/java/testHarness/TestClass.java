package testHarness;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.ConfigClass;
import generic.PropertyLoader;
import pom.swagLabs.LandingPage;

public class TestClass extends ConfigClass {
	LandingPage lp;
	SoftAssert sa;

	@Test(dataProvider = "getData")
	public void login(String userName, String password)
			throws IOException, InterruptedException {

		driver.get(PropertyLoader.getPropertyValue("url"));
		lp = new LandingPage(driver);
		lp.loginWithValidCredential(userName, password);
		Thread.sleep(3000);
		sa = new SoftAssert();
		sa.assertEquals(lp.verifyProductName(),
				PropertyLoader.getPropertyValue("productName"));
		System.out.println(lp.verifyProductName());
		sa.assertAll();
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[4][2];
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";
		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";
		data[3][0] = "performance_glitch_user";
		data[3][1] = "secret_sauce";

		return data;
	}

}
