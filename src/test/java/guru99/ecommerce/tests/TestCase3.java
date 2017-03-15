package guru99.ecommerce.tests;

import org.testng.annotations.Test;
import guru99.ecommerce.pages.MainPage;
import guru99.ecommerce.pages.MobilePage;

public class TestCase3 extends Settings {

	@Test
	public void Test1 () {
		
		
		MainPage mnp = new MainPage(driver);
		
		mnp.headerItems("MOBILE").click();

		MobilePage mobp = new MobilePage(driver);
		
		mobp.AddToCart();
		mobp.Shop("1000");
		mobp.updateqty();
		mobp.Updaterr();
		mobp.Empcart();
		
}
}
