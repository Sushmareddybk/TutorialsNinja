package tutorialsNinjaTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tutorialsNinjaCommon.BaseTest;
import tutorialsNinjaPages.HeaderPage;
import tutorialsNinjaPages.LoginPage;
import tutorialsNinjaPages.MyAccountPage;
import tutorialsNinjaPages.NewsLetterPage;

public class NewsLetterSubscriptionTest extends BaseTest{
  @Test
  public void verifySubscribeToNewsLetterFunctionality() {
	  String expectedResult = "Success: Your newsletter subscription has been successfully updated!";
	 
	  HeaderPage header = new HeaderPage(driver);
	  test.info("click On MyAccount And Select Login");
	  LoginPage login = header.clickOnMyAccountSelectLogin(); 
	  test.pass("Navigated Successfully To Login Page");
	  MyAccountPage myAccount = login.enterLoginCredentialsAndClickOnLogin("sushmareddy@gmail.com", "Testing");
	  NewsLetterPage newsLetter = myAccount.clickOnSubscribeUnsubscribeToNewsletter();//
	  newsLetter.clickYesToSubscribeAndContinue();
	  String actualResult = myAccount.getSubscriptionSuccessMsg();
	  Assert.assertEquals(actualResult, expectedResult);
  }
}
