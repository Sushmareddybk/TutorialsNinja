package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {
	WebDriver driver;
	By addToWishListButton = By.xpath("//div[@class='button-group']//button[2]");
	By successMsg = By.className("alert-success");
	By iphoneSelect = By.partialLinkText("img-responsive");
	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
	}
	public WishListPage addProductToWishList() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(addToWishListButton).click();
		return new WishListPage(driver);
	}
	public String getAddToWishListSucsessMessage() {
		return driver.findElement(successMsg).getText();
	}
}
