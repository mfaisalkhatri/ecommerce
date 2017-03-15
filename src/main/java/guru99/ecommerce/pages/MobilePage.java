package guru99.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MobilePage {

	private static WebDriver driver;
	
	private static final By sortopt = By.cssSelector("div.toolbar-bottom .sort-by>select");
	private static final By moboptions = By.cssSelector("div.category-products > ul > li");
	private static final By mobprice = By.cssSelector("#product-price-1 > span.price");
	private static final By sonyaddcart = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button");
	private static final By qty = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
	private static final By updbtn = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
	private static final By errtext = By.cssSelector(".item-msg.error");
	private static final By empcart = By.cssSelector("#empty_cart_button");
	private static final By empmsg = By.cssSelector(".page-title>h1");
	
	public WebElement sOptions () {
		WebElement select = driver.findElement(sortopt);
		
		return select;
	}
	
	
	public WebElement mobOptions (String mobname) {
		List<WebElement> options = driver.findElements(moboptions);
		for (WebElement item: options) {
			WebElement title = item.findElement(By.tagName("h2"));
			if(title.getText().equals(mobname)) {
				return item;
			}
		}
		return null;
	}
	
	public String MobPrice() {
		
		WebElement price1 = driver.findElement(mobprice);
		
		String price = price1.getText();
	
		return price;
		
	}
	
	public void Page2Price () {
		
		WebElement sonyprice = driver.findElement(mobprice);
		String price = sonyprice.getText();
		
		Assert.assertEquals(MobPrice(),price);
	}
	
	public void AddToCart() {
		WebElement sonyadd = driver.findElement(sonyaddcart);
		sonyadd.click();

	}

	public void Shop (String quantity) {
		
		WebElement qtyy = driver.findElement(qty);
		qtyy.clear();
		qtyy.click();
		qtyy.sendKeys(quantity);
	}
	
	public void updateqty () {
		WebElement update = driver.findElement(updbtn);
		WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(updbtn));
		update.click();

	}
	
	public void Updaterr () {
		WebElement errortext = driver.findElement(errtext);
		String msg = errortext.getText();
		String expected = "* The maximum quantity allowed for purchase is 500.";
		
		Assert.assertEquals(expected, msg);		
	}
	
	public void Empcart () {
		WebElement emptycart = driver.findElement(empcart);
		emptycart.click();
		
		
		WebElement emppmsg = driver.findElement(empmsg);
		String empcrtmsg = emppmsg.getText();
		
		String expmsg = "SHOPPING CART IS EMPTY";
		
		Assert.assertEquals(expmsg, empcrtmsg);

	}
	

	public MobilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		MobilePage.driver = driver;
	}
}
