package cosmetic.tests;

import org.testng.annotations.Test;

import cosmetic.pages.SearchProductPage;

public class SearchProductTest extends BaseTest{
	 @Test(priority = 2)
	    public void homePageTest() throws InterruptedException {
	        SearchProductPage searchProd = new SearchProductPage(driver);
	        searchProd.selectCatalog();
	        searchProd.clickProduct("Coffret wishes - K-reine");
	      searchProd.assertProductTitle();
	        //Thread.sleep(5000);

	    }
}
