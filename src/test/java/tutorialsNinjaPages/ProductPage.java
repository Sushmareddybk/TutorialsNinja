package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	By addToWishList = By.xpath("//button[@text='Add to Wish List']");
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToaddProductToWishList() {
		driver.findElement(addToWishList).click();
	}
}
