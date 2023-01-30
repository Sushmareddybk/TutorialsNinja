package tutorialsNinjaTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.AddAddressPage;
import tutorialsNinjaPages.AddressBookPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;

public class ModifyAddressBookEntriesTest extends BaseTest {
	@Test
	public void verifyAddressBookEntriesForValidCase() {
		String expectedResult =  "Your address has been successfully added";
		String expectedResult1 = "peppa";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
		AddressBookPage address = myAccount.clickOnModifyAddressBookEntries();
		AddAddressPage addAddress = address.clickOnNewAddress();
		addAddress.addAddressAndClickOnContinue(expectedResult1,"chuchuTv1","98765");
		SoftAssert softAssert = new SoftAssert();
		String actualResult = address.getSuccessfullyAddedAddressMsg();
		softAssert.assertEquals(actualResult, expectedResult); 
		String actualResult1 = address.getAddressBookEntries();
		if (actualResult1.contentEquals(expectedResult1)) {
			softAssert.assertEquals(actualResult1, expectedResult1);
			softAssert.assertAll();
		}else
			System.out.println("Address Not Found In Address Book");
	}
}
