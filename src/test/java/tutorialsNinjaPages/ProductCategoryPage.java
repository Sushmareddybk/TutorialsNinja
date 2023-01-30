package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryPage {
	WebDriver driver;
	By product1 = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][1]");
	By compareButton = By.xpath("//button[@data-original-title='Compare this Product']");
	By alertSuccess = By.className("alert-success");
	By product2 = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][2]");
	By productCompareBtn = By.xpath("//div[@id='content']//a[@id='compare-total']");
	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	public String addToCompareProduct2() {
		String productModel1 = driver.findElement(product1).getText();
		if (productModel1.contains("Canon EOS 5D")) {
			driver.findElement(compareButton).click();
			return driver.findElement(alertSuccess).getText();
		}else
			System.out.println("RequiredProductIsNotPresent");
		return null;	
	}
	public String addToCompareProduct1() throws InterruptedException {
		String productModel2 = driver.findElement(product2).getText();
		if (productModel2.contains("Nikon D300")) {
			driver.findElement(compareButton).click();
			return driver.findElement(alertSuccess).getText();		
		}else
			System.out.println("RequiredProductIsNotPresent");
		return null;
	}
	public ProductComparePage navigateToProductComparison() {
		driver.findElement(productCompareBtn).click();
		return new ProductComparePage(driver);
	}
}
