package tutorialsNinjaTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;

public class LoginTest extends BaseTest  {
	@DataProvider
	public Object[][] loginData() {
		return new Object[][] {
			new Object[] {"sushmareddy@gmail.com", "Testing", "valid" },
			new Object[] {"sushmareddy", "Testing", "inValid" },
		};
	}
	@Test (dataProvider = "loginData")
	public void verifyLoginFunctionality(String email, String password, String validOrInvalid) {
		String expectedResult = "Edit your account information";
		String expectedRes = "http://tutorialsninja.com/demo/index.php?route=account/login";
		HeaderPage headerPage = new HeaderPage(driver);
		LoginPage loginPage = headerPage.clickOnMyAccountSelectLogin(); 
		MyAccountPage myAccountPage = loginPage.enterLoginCredentialsAndClickOnLogin(email, password);
		SoftAssert softAssert = new SoftAssert();
		if (validOrInvalid.equalsIgnoreCase("valid")) {
			String actualResult = myAccountPage.getEditAccountInfoText();
			softAssert.assertEquals(actualResult, expectedResult);

		}else {
			String actualResult1 = loginPage.getLoginPageUrl();
			softAssert.assertEquals(actualResult1, expectedRes);
			softAssert.assertAll();
		}
	}
}
