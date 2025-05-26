package cosmetic.tests;

import org.testng.annotations.Test;
import cosmetic.pages.AddProdPage;

public class AddCartTest extends BaseTest{
	 @Test(priority = 3)
	    public void addProd() throws InterruptedException {
	        AddProdPage addProdPage = new AddProdPage(driver);
	        addProdPage.addprod();
	        Thread.sleep(5000);
	        addProdPage.assertCartProduct();
	       // Thread.sleep(5000);

	    }
}

