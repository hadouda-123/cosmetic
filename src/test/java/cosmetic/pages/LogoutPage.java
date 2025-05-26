package cosmetic.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LogoutPage {
	WebDriver driver;
//Locators
	private final By account=By.id("header-user-btn");
	private final By btnlogout=By.cssSelector("a[href='https://cosmetique.tn/?mylogout=']");
	//constructeur
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	public void logout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String zoomChrome = "document.body.style.zoom='50.0%'";
	    js.executeScript(zoomChrome);

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement accountSpan = wait.until(ExpectedConditions.elementToBeClickable(account));

			accountSpan.click();

			WebElement logoutSpan = wait.until(ExpectedConditions.elementToBeClickable(btnlogout));

			logoutSpan.click();

			Thread.sleep(3000);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	public void assertLoginPage() {
		String expectedurl="https://cosmetique.tn/panier?action=show";
		String actualurl=driver.getCurrentUrl();
		Assert.assertEquals(expectedurl, actualurl);
		}
}
