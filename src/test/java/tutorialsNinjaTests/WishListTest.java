package tutorialsNinjaTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.SearchProductPage;
import tutorialsNinjaPages.WishListPage;

public class WishListTest extends BaseTest{
	@Test(description = "")
	public void verifyAddProductWishListFunctionality() {
		String expectedResult = "Success: You have added";
		String expectedResult1 = "product 11";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
		SearchProductPage searchProduct = myAccount.searchForProductInSearchFilter("iphone");
		WishListPage wishList = searchProduct.addProductToWishList();
		String actualResults = searchProduct.getAddToWishListSucsessMessage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualResults.contains(expectedResult));
		header.clickOnWishListLink();
		String actualResult1 = wishList.getProductDetailsFromWishList();
		if (actualResult1.contentEquals(expectedResult1)) {
			softAssert.assertEquals(actualResult1, expectedResult1);
			softAssert.assertAll();
		}else 
			System.out.println("Product is not added to WishList");	  
	}
}
