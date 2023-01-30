package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductComparePage {
	WebDriver driver;
	By product1Name = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/strong[1]");
	By product2Name = By.xpath("//strong[contains(text(),'Canon EOS 5D')]");
	public ProductComparePage(WebDriver driver) {
		this.driver = driver;
	}
	public String nameOfProduct1() {
		return driver.findElement(product1Name).getText();	
	}
	public String nameOfProduct2() {
		return driver.findElement(product2Name).getText();
	}
	public String priceofCanonEOS5D() {
		return driver.findElement(By.xpath("//td//strike[1]")).getText();
	}
}
