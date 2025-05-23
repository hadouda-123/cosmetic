package cosmetic.pages;
import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {
	WebDriver driver;
    WebDriverWait wait;
    By emailInput = By.id("field-email");
    By passwordInput = By.id("field-password");
    By loginButton = By.id("submit-login");
    By goHome = By.cssSelector("a .logo");
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void login(String email, String password) throws InterruptedException {
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
      
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(goHome));

        driver.findElement(goHome).click();
    }
    public boolean isLoginSuccessful() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.urlToBe("https://cosmetique.tn/"));

    }
}
