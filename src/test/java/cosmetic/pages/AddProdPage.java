package cosmetic.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AddProdPage {

	WebDriver driver;

    WebDriverWait wait;



    By add = By.cssSelector("button.btn.btn-primary.btn-lg.add-to-cart");

    By visibleModal = By.id("blockcart-modal");

    By btnCom = By.cssSelector("#blockcart-modal .cart-content-btn a.btn.btn-primary");

    By prodTitle = By.cssSelector("div.col-9 .product-line-info .label");



    public AddProdPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public void addprod() throws InterruptedException {

    	JavascriptExecutor js = (JavascriptExecutor) driver;

		String zoomChrome = "document.body.style.zoom='50.0%'";

	    js.executeScript(zoomChrome);

    	new WebDriverWait(driver, Duration.ofSeconds(15))

        .until(ExpectedConditions.elementToBeClickable(add))

        .click();
        try {

            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(visibleModal));

            WebElement commander = wait.until(ExpectedConditions.elementToBeClickable(btnCom));

            commander.click();



        } catch (Exception e) {

            System.out.println("Add to cart failed: " + e.getMessage());

        }

    }

    

    public void assertCartProduct() {

    	

        String expectedUrl = "https://cosmetique.tn/panier?action=show";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);



        String expectedProductTitle = "Coffret crème brulée - K-reine";

        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(prodTitle));

        String actualTitle = titleElement.getText().trim();

        Assert.assertEquals(expectedProductTitle, actualTitle);

    }
}
