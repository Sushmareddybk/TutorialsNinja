package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.CheckOutCartPage;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.SearchProductPage;
import tutorialsNinjaPages.WishListPage;

public class EstimateShippingAndTaxesTest extends BaseTest{
	@Test
	public void verifyEstimateShippingAndTaxes() {
		String expectedResult = "Success: Your shipping estimate has been applied!×";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
		SearchProductPage searchProduct  = myAccount.searchForProductInSearchFilter("iphone");
		WishListPage wishList = searchProduct.addProductToWishList();
		header.clickOnWishListLink();//
		wishList.clickOnAddToCartButton();
		CheckOutCartPage checkOut = header.clickOnShoppingCartLink();
		checkOut.enterEstimateShippingTaxes();
		checkOut.selectAndapplyShipping();
		String actualResult = checkOut.getShippingEstimateAppliedSuccessMsg().trim();
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
}

