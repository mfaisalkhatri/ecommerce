package guru99.ecommerce.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import guru99.ecommerce.pages.MainPage;
import guru99.ecommerce.pages.MobilePage;

public class TestCase4 extends Settings {
	
	
	
	@Test
	public void Test4()  {
	MainPage mnp = new MainPage(driver);
	
	mnp.headerItems("MOBILE").click();

	MobilePage mobp = new MobilePage(driver);
	
		
	
	mobp.sonyclick();
	mobp.successmsg();
	mobp.iphoneclick();
	mobp.successmsg();
	mobp.compclick();
	
	mobp.popupwindow();
	
	}
	
}
