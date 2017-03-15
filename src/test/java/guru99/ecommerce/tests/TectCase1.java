package guru99.ecommerce.tests;


import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import guru99.ecommerce.pages.MainPage;
import guru99.ecommerce.pages.MobilePage;


public class TectCase1 extends Settings{

	@Test
	public void Test1 () {
		
		String wintitle, mobtitle;
		MainPage mnp = new MainPage(driver);
		
		wintitle = driver.getTitle();
		System.out.println("Title of the Main window is - " + wintitle);

		Assert.assertEquals("Home page", wintitle);
		
		mnp.headerItems("MOBILE").click();
		
		mobtitle = driver.getTitle();
		System.out.println("Title of the Main window is - " + mobtitle);
		
		Assert.assertEquals("Mobile", mobtitle);
		
	MobilePage mobp = new MobilePage(driver);
	Select opt = new Select (mobp.sOptions());
	opt.selectByVisibleText("Name");

		
	}
	
	
	
}
