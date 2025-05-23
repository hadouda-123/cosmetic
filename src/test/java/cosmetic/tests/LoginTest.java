package cosmetic.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import cosmetic.pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("hajjihadouda328@gmail.com", "Hajji2025$");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed: URL did not redirect");
        Thread.sleep(5000);
    }

}
