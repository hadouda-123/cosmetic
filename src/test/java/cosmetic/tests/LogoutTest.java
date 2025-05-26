package cosmetic.tests;

import org.testng.annotations.Test;

import cosmetic.pages.LogoutPage;

public class LogoutTest extends BaseTest {
	@Test(priority=4)
	public void logout() throws InterruptedException {
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.logout();
		logoutpage.assertLoginPage();
		//Thread.sleep(5000);
	}
}
