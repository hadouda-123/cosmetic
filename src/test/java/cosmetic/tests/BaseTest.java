package cosmetic.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

public class BaseTest {
	protected static WebDriver driver;

	@Parameters("url")

	@BeforeTest

	public void setUp(String url) {

		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get(url);
		}
	}

	@AfterTest

	public void teardown() {

		if (driver != null) {

			driver.quit();

		}

	}
}
