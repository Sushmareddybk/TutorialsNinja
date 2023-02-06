package tutorialsNinjaTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.ProductCategoryPage;
import tutorialsNinjaPages.ProductComparePage;

public class ComparisionOfProductsTest extends BaseTest{
	@DataProvider
	public Object[][] ComparingProductsData() {
		return new Object[][] {
			new Object[] {"sushma@gmail.com", "valid" },
		};
	}
	@Test(dataProvider = "ComparingProductsData")
	public void productsComparison(String email, String password) throws InterruptedException {
		String expectedResult = "Success: You have added Canon EOS 5D to your product comparison! ";
		String expectedResult2 = "Canon EOS 5D";
		String expectedResult1 = "Nikon D300";
		String expectedResult3 = "Success: You have added Nikon D300 to your product comparison!";
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnMyAccountSelectLogin();
		MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin(email, password);
		ProductCategoryPage productCategory = myAccount.clickToNavigateCamerasLink();
		String actualResult = productCategory.addToCompareProduct2();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualResult.contains(expectedResult));
		ProductComparePage compareProduct = productCategory.navigateToProductComparison();
		String actualResult2 = compareProduct.nameOfProduct2();
		compareProduct.priceofCanonEOS5D();

		if (actualResult2.contains(expectedResult2)) {
			softAssert.assertEquals(actualResult2, expectedResult2);
			System.out.println("Product2: Canon EOS 5D is added successfully to Product Comparision");
		}else {
			softAssert.assertNotSame(actualResult2, expectedResult2);
			System.out.println("Canon EOS 5D ProductNotFound");
		}
		myAccount.clickToNavigateCamerasLink();
		String actualResult1 = productCategory.addToCompareProduct1();
		softAssert.assertTrue(actualResult1.contains(expectedResult3));
		if (actualResult.contains(expectedResult)) {
			softAssert.assertEquals(actualResult, expectedResult1);
			System.out.println("Product2: NIKON D300 is added successfully to Product Comparision");
		}else {
			softAssert.assertNotSame(actualResult, expectedResult1);
			System.out.println("NIKON D300 ProductNotFound");
		}
	}	
}


