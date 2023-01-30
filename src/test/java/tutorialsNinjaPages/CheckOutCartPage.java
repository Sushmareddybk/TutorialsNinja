package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutCartPage {
	WebDriver driver;
	By country = By.xpath("//div[@class='form-horizontal']//select[@name='country_id']");
	By region = By.xpath("//div[@class='form-group required']//select[@name='zone_id']");
	By postCode = By.id("input-postcode");
	By getQuotes = By.id("button-quote");
	By applyShipping =By.id("button-shipping");
	By estimateShipping = By.partialLinkText("Estimate Shipping & Taxes");
	By product = By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']//td[2]");
	By product1 = By.xpath("//form[@enctype='multipart/form-data']//div[@class='table-responsive']");
	public  CheckOutCartPage(WebDriver driver) {
		this.driver = driver;
	}
	public String checkForProductInShoppingCart() {
		return driver.findElement(product).getText();
	}
	public void enterEstimateShippingTaxes(){
		driver.findElement(estimateShipping).click();
		new Select(driver.findElement(country)).selectByIndex(5);
		new Select(driver.findElement(region)).selectByValue("118");
		driver.findElement(postCode).sendKeys("45369");
	}
	public void selectAndapplyShipping() {
		driver.findElement(getQuotes).click();
		driver.findElement(By.name("shipping_method")).click();
		driver.findElement(applyShipping).click();
	}
	public String getShippingEstimateAppliedSuccessMsg() {
		return driver.findElement(By.className("alert-success")).getText();		
	}
	public String checkForGiftCertificate() {
		return driver.findElement(product1).getText();
	}
}
