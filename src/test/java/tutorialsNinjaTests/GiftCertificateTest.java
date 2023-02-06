package tutorialsNinjaTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.CheckOutCartPage;
import tutorialsNinjaPages.GiftVoucherPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.VoucherSuccessMsgPage;

public class GiftCertificateTest extends BaseTest{
	@DataProvider
	public Object[][] GiftCertificateData() {
		return new Object[][] {
			new Object[] {"sushmareddy@gmail.com", "Testing"},
		};
	}
	@Test(dataProvider = "GiftCertificateData")
	public void giftCertificateWithRefundableTerms(String email, String password) {
		String expectedResult = "Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.";
		String expectedResult1 = "$1.00 Gift Certificate for ben";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin(); 
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin(email, password);
		GiftVoucherPage giftVoucher = myAccount.clickOnGiftCertificatesLink();
		giftVoucher.enterGiftCertificateDetails();
		VoucherSuccessMsgPage voucherSuccess = giftVoucher.clickToNavigateVoucherSuccessPage();
		String actualResult = voucherSuccess.getPurchasingGiftCertificateSuccessMsg();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualResult, expectedResult);
		CheckOutCartPage checkOut = voucherSuccess.clickContinueToCheckOut();
		String actualResult1 = checkOut.checkForGiftCertificate();
		softAssert.assertEquals(actualResult1, expectedResult1);
		softAssert.assertAll();
		System.out.println("Gift Certificate Not Found");
	}
	@Test(dataProvider = "GiftCertificateData")
	public void giftCertificateWithOutNonRefundableTerms(String email, String password) {
		String expectedResult = "Warning: You must agree that the gift certificates are non-refundable!";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin(); 
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin(email, password);
		GiftVoucherPage giftVoucher = myAccount.clickOnGiftCertificatesLink();
		giftVoucher.giftCertificateWithOutAgreeingToTerms();
		giftVoucher.clickToNavigateVoucherSuccessPage();
		String actualResult = giftVoucher.nonRefundableTerms();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualResult, expectedResult);
		softAssert.assertAll();
	}
}
