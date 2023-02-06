package tutorialsNinjaTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.CheckOutCartPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.SearchProductPage;
import tutorialsNinjaPages.WishListPage;

public class AddProductToCartTest extends BaseTest{
	@Test
	public void verifyAddToCartFunctionalityFromWishList() {
		String expectedResult = "Success: You have added"; 
		String expectedResult1 = "iPhone";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
		SearchProductPage searchProduct  = myAccount.searchForProductInSearchFilter("iphone");
		WishListPage wishList = searchProduct.addProductToWishList();
		header.clickOnWishListLink();
		wishList.clickOnAddToCartButton();
		String actualResult = wishList.getAddToCartSuccessMsg();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualResult.contains(expectedResult));
		CheckOutCartPage checkOut = header.clickOnShoppingCartLink();
		String actualResult1 = checkOut.checkForProductInShoppingCart();
		softAssert.assertEquals(actualResult1, expectedResult1);
		softAssert.assertAll();

	}
}
