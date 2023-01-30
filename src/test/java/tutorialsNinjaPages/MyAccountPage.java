package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	WebDriver driver;
	By editAccountLink = By.partialLinkText("Edit your account information");
	By alertSuccessMsg = By.className("alert-success");
	By modifyAddressBook = By.partialLinkText("Modify your address book entries");
	By searchField = By.name("search");
	By searchButton = By.className("btn-default");
	By subscribeUnsubscribe = By.partialLinkText("Subscribe / unsubscribe to newsletter");
	By subscriptionSuccessMsg = By.className("alert-success");
	By giftCertificatesLink = By.partialLinkText("Gift Certificates");
	By editAccount = By.partialLinkText("Edit Account");
	By camerasLink = By.xpath("//ul[@class='nav navbar-nav']//li[7]");
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getEditAccountInfoText() {
		String editAccountInfo = driver.findElement(editAccountLink).getText();
		return editAccountInfo;
	}
	public EditAccountPage clickOnEditYourAccountInformation() {
		driver.findElement(editAccountLink).click();
		return new EditAccountPage(driver);
	}
	public String getAccountUpdatedSuccessMessage() {
		String accountSuccessMessage = driver.findElement(alertSuccessMsg).getText();
		return accountSuccessMessage;
	}
	public void clickOnEditAccountInRightColumn() {
		driver.findElement(editAccount).click();
	}
	public AddressBookPage clickOnModifyAddressBookEntries() {
		driver.findElement(modifyAddressBook).click();	
		return new AddressBookPage(driver);
	}
	public SearchProductPage searchForProductInSearchFilter(String product) {
		driver.findElement(searchField).sendKeys(product);
		driver.findElement(searchButton).click();
		return new SearchProductPage(driver);
	}
	public NewsLetterPage clickOnSubscribeUnsubscribeToNewsletter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(subscribeUnsubscribe).click();
		return new NewsLetterPage(driver);
	}
	public String getSubscriptionSuccessMsg() {
		return driver.findElement(subscriptionSuccessMsg).getText();
	}
	public GiftVoucherPage clickOnGiftCertificatesLink() {
		driver.findElement(giftCertificatesLink).click();
		return new GiftVoucherPage(driver);
	}
	public ProductCategoryPage clickToNavigateCamerasLink() {
		driver.findElement(camerasLink).click();
		return new ProductCategoryPage(driver);		
	}
}
