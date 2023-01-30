package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HeaderPage {
	WebDriver driver;
	By myAccountLink = By.xpath("//span[text()='My Account']");
	By registerLink = By.partialLinkText("Register");
	By loginLink = By.partialLinkText("Login");
	By logoutLink = By.partialLinkText("Logout");
	By wishListOption = By.xpath("//a[@id='wishlist-total']");
	By shoppingCart = By.partialLinkText("Shopping Cart");
	public HeaderPage(WebDriver driver) {
		this.driver=driver;
	}
	public RegisterAccountPage clickOnMyAccountSelectResigter() {
		driver.findElement(myAccountLink).click();
		driver.findElement(registerLink).click();
		return new RegisterAccountPage(driver);	
	}
	public LoginPage clickOnMyAccountSelectLogin() {
		driver.findElement(myAccountLink).click();
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	public WishListPage clickOnWishListLink() {
		driver.findElement(wishListOption).click();
		return new WishListPage(driver);
	}
	public void clickOnLogout() {
		driver.findElement(logoutLink).click();

	}
	public CheckOutCartPage clickOnShoppingCartLink() {
		driver.findElement(shoppingCart).click();
		return new CheckOutCartPage(driver);		
	}
}
