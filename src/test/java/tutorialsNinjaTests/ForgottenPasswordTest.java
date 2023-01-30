package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.ForgottenPasswordPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;

public class ForgottenPasswordTest extends BaseTest {
	String expectedResult = "An email with a confirmation link has been sent your email address.";
	String expectedResult1 = "Warning: The E-Mail Address was not found in our records, please try again!";
	@DataProvider
	public Object[][] ForgotPasswordData() {
		return new Object[][] {
			new Object[] {"sushma@gmail.com", "valid" },
			new Object[] {"sushmacom", "inValid" },
		};
	}
	@Test(dataProvider = "ForgotPasswordData")
	public void verifyForgottenPasswordInRightColumnValidCase(String email, String validOrInValid) {
		HeaderPage headerPage = new HeaderPage(driver);
		LoginPage loginPage = headerPage.clickOnMyAccountSelectLogin();			
		ForgottenPasswordPage frgtPswdPage = loginPage.clickOnForgottenPasswordInRightColumn();
		frgtPswdPage.enterEmailAndClickContinue(email);
		if (validOrInValid.equalsIgnoreCase("valid")) {
			String actualResult = frgtPswdPage.displayingAlertSuccessMessage();	 		
			Assert.assertEquals(actualResult, expectedResult);
		}else {
			String actualResult1 = frgtPswdPage.displayingAlertWarningMessage();	 		
			Assert.assertEquals(actualResult1, expectedResult1);
		}	
	}
	@Test(dataProvider = "ForgotPasswordData")
	public void verifyForgottenPasswordInLoginFieldValidCase(String email, String validOrInValid) {	
		HeaderPage headerPage = new HeaderPage(driver);
		LoginPage loginPage = headerPage.clickOnMyAccountSelectLogin();			
		ForgottenPasswordPage frgtPswdPage = loginPage.clickOnForgottenPasswordInLoginField();
		frgtPswdPage.enterEmailAndClickContinue(email);
		if (validOrInValid.equalsIgnoreCase("valid")) {
			String actualResult = frgtPswdPage.displayingAlertSuccessMessage();	 		
			Assert.assertEquals(actualResult, expectedResult);
		}else {
			String actualResult1 = frgtPswdPage.displayingAlertWarningMessage();	 		
			Assert.assertEquals(actualResult1, expectedResult1);
		}		
	}
}
