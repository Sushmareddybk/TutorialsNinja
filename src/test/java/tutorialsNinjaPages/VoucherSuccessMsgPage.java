package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VoucherSuccessMsgPage {
	WebDriver driver;
	By giftCertificateMsg = By.xpath("//div[@id='content']//p");
	By checkOutLink = By.xpath("//div[@id='content']//div//a");
	public VoucherSuccessMsgPage(WebDriver driver) {
		this.driver = driver;
	}
	public  String getPurchasingGiftCertificateSuccessMsg() {
		return driver.findElement(giftCertificateMsg).getText();
	}
	public CheckOutCartPage clickContinueToCheckOut() {
		driver.findElement(checkOutLink).click();
		return new CheckOutCartPage(driver);
	}
}
