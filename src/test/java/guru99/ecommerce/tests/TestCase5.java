package guru99.ecommerce.tests;

import org.testng.annotations.Test;

import guru99.ecommerce.pages.AcctCreation;
import guru99.ecommerce.pages.MainPage;

public class TestCase5 extends Settings{
	
	@Test
	public void Test5() {
	
	MainPage mnp = new MainPage(driver);
	mnp.MyActclick();
	mnp.windowhandlechange();
	mnp.CreateAct();
	AcctCreation create = new AcctCreation(driver);
	
	mnp.windowhandlechange();
	create.CreateAcct("tom1", "Dsouza1", "tom.d1@gmail.com", "Pass123", "Pass123");
	create.successmsg();
	
	mnp.headerItems("TV").click();
	
}
}