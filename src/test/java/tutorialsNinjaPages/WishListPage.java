package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WishListPage {
	WebDriver driver;
	By productInWishList = By.xpath("//div[@id='content']//div[@class='table-responsive']//tbody");
			//By.xpath("//table[@class='table table-bordered table-hover']");
	By addToCart = By.xpath("//div[@id='account-wishlist']//div//table//td[6]//button");
	By addToCartSuccessMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By deleteProduct = By.xpath("//tbody/tr/td[6]/a[@class='btn btn-danger']");
	By deleteProductSuccessMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By wishListIsEmpty = By.id("content");
	By sizeOfWishList = By.className("table-responsive");
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getProductDetailsFromWishList() {
		return driver.findElement(productInWishList).getText();
	}
	public boolean checkForProductPresenceInWishList() {
		if (driver.findElement(productInWishList).isDisplayed()) {
			System.out.println("Product Removal Is Not Successfull");
			return false;
		}else
			return true;	
	}
	public void clickOnAddToCartButton() {
		driver.findElement(addToCart).click();
	}
	public String getAddToCartSuccessMsg() {
		return driver.findElement(addToCartSuccessMsg).getText();
	}
	public WishListPage deleteProductFromWishList() {
		driver.findElement(deleteProduct).click();
		return new WishListPage(driver);
	}
	public String getDeleteProductSuccessMsg() {
		return driver.findElement(deleteProductSuccessMsg).getText();	
	}
	public String getWishListIsEmptyMsg() {
		return driver.findElement(wishListIsEmpty).getText();
	}
	public Dimension getSizeOfWishList() {
		return driver.findElement(sizeOfWishList).getSize();
	}
}
