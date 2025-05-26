package cosmetic.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class SearchProductPage {
	WebDriver driver;
	WebDriverWait wait;
	private final By products = By.cssSelector("article.product-miniature");
	private final By selectcatalog = By.linkText("Parfums");// sélectionner lien
	private final By search = By.cssSelector("#search_widget input[name='s']");
	private final By scrolltoproduct = By.id("js-product-list");
	private final By clickOnTitle = By.cssSelector(".product-thumbnail");
	private final By prodTitle = By.cssSelector("h1.page-title span");

	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

//cliquer sur le lien Parfums
	public void selectCatalog() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String zoomChrome = "document.body.style.zoom='50.0%'";
	    js.executeScript(zoomChrome);
		WebElement parfumlink = driver.findElement(selectcatalog);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parfumlink);// scroll found
																										// Parfums
		parfumlink.click();
	}

	public void clickProduct(String title) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String zoomChrome = "document.body.style.zoom='50.0%'";
	    js.executeScript(zoomChrome);
//chercher le produit selon input search
		WebElement inputsearch = driver.findElement(search);
		inputsearch.sendKeys(title);
		inputsearch.sendKeys(Keys.ENTER);
		// scroll down to found product
		WebElement scrolproduct = driver.findElement(scrolltoproduct);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
		// wait lilproduit get class img
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(clickOnTitle));
		// cliquer sur le produit
		productImage.click();
		//Thread.sleep(500);
	}

	public void assertProductTitle() {
		String expectedTitle = "Coffret wishes - K-reine";
		WebElement titleElement = driver.findElement(prodTitle);
		String actualTitle = titleElement.getText();
		Assert.assertEquals(expectedTitle, actualTitle);

	}
}
