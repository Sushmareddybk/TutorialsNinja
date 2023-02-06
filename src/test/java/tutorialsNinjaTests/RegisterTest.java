package tutorialsNinjaTests;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaCommon.CommonUtils;
import tutorialsNinjaPages.AccountSuccessPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.RegisterAccountPage;

public class RegisterTest extends BaseTest  {
	Logger log =  LogManager.getLogger(RegisterTest.class);
	@DataProvider
	public Object[][] RegisterData() {
		return new Object[][] {
			new Object[] {CommonUtils.generateRandomString()+"@gmail.com", CommonUtils.generateRandomInteger(), "Listeners", "Listeners", "valid"},
			new Object[] {"sushmareddygmail.com", "0789654336", "sushmnbvc", "sushmnbvc", "inValid"},
		};
	}
	@Test (dataProvider = "RegisterData")
	public void verifyRegisterAccountFunctionality(String email, String telephoneNum, String password, String confirmPassword, String validOrInValid) {
		log.info("Test case verifyRegisterAccountFunctionality starts execution");
		String expectedResult = "Your Account Has Been Created!";
		String expectedRes = "http://tutorialsninja.com/demo/index.php?route=account/register";
		HeaderPage headerPage  = new HeaderPage(driver);
		log.info("Click on My Account link to navigate to registration page");
		RegisterAccountPage registerAccountPage = headerPage.clickOnMyAccountSelectResigter();	 
		log.info("Enter personal details and click on submit button");
		AccountSuccessPage accountRegisterSuccessMsg = registerAccountPage.enterPersonalDetailsAndClickSubmit(email, telephoneNum, password, confirmPassword);
		log.info("Get account register success message");
		String actualResult = accountRegisterSuccessMsg.getAccountRegisterSuccessMsg();
		log.info("Get account register page URL");
		String actualResult1 = registerAccountPage.getRegisterAccountPageUrl();
		SoftAssert softAssert = new SoftAssert();
		if (validOrInValid.contains("valid")) {
			softAssert.assertTrue(actualResult.contains(expectedResult));
		log.info("ValidTestCase: Registration success message matched with expected message");
		}else
			softAssert.assertEquals(actualResult1, expectedRes);
		log.info("InvalidTestCase: Registration success message not matched with expected message");
		softAssert.assertAll();
		log.info("test is complete");
	}

}
