package tutorialsNinjaTests;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.SearchProductPage;
import tutorialsNinjaPages.WishListPage;

public class DeleteProductInWishListTest extends BaseTest {
	@Test
	public void verifyProductRemovalFromWishListFunctionality() {
		String expectedResult = "Success: You have modified your wish list!";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
		SearchProductPage searchProduct  = myAccount.searchForProductInSearchFilter("iphone");
		WishListPage wishList = searchProduct.addProductToWishList();
		header.clickOnWishListLink();
		Dimension sizeOfWishList = wishList.getSizeOfWishList();
		System.out.println("Size of wishlist before DeletingProduct:" + sizeOfWishList);
		wishList.deleteProductFromWishList();
		SoftAssert softAssert = new SoftAssert();
		String actualResult = wishList.getDeleteProductSuccessMsg();
		softAssert.assertTrue(actualResult.contains(expectedResult));
		Dimension sizeOfWishListAfterProductRemoval = wishList.getSizeOfWishList();
		System.out.println("Size of wishlist after DeletingProduct:" + sizeOfWishListAfterProductRemoval);
		softAssert.assertTrue(sizeOfWishListAfterProductRemoval.getWidth() < sizeOfWishList.getWidth() || sizeOfWishListAfterProductRemoval.getHeight() < sizeOfWishList.getHeight());
		softAssert.assertAll();
	}	
}
