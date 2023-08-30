package tutorialsNinjaTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.EditAccountPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;

public class EditAccountInformationTest extends BaseTest{
	@Test
	public void verifyEditAccountInfoForValidCase() {
		String expectedResult = "Success: Your account has been successfully updated.";//  
		String expectedResult1 = "chuchu";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
		EditAccountPage editAccount = myAccount.clickOnEditYourAccountInformation();
		editAccount.editPersonalInformationAndClickContinueToSubmit(expectedResult1, "chicha");
		String actualResult = myAccount.getAccountUpdatedSuccessMessage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualResult, expectedResult);
		myAccount.clickOnEditYourAccountInformation();
		String actualResult1 = editAccount.checkForUpdatedInfo();
		softAssert.assertTrue(actualResult1.contains(expectedResult1));
		softAssert.assertAll();
	}
}
