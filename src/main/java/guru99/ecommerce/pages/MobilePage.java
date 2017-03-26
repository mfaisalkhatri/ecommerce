package guru99.ecommerce.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	
	private static final By compsonyex = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a");
	private static final By compiphone = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a");
	private static final By addmsg = By.cssSelector (".success-msg>ul>li>span");
	private static final By compbtn = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[3]/div[1]/div[2]/div/button");
	//private static final By compmob = By.cssSelector(".product-shop-row.top.first.odd>td .product-name [title = 'Sony Xperia']");  
	private static final By compmob = By.cssSelector(".product-shop-row.top.first.odd>td");
	
	


	
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
	
// Code for Test Case 4 start from here

	
	public void sonyclick () {
		
		/*try {
			WebDriverWait wait = new WebDriverWait(driver,5);
		    wait.until(ExpectedConditions.elementToBeClickable(compsonyex));
		} 
		catch (org.openqa.selenium.TimeoutException e) {
		    System.out.println(driver.getPageSource());
		}*/
	//This Method Clicks on Sony Experia mobile Add to compare link.	
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement sonycomp = driver.findElement(compsonyex);
		wait.until(ExpectedConditions.elementToBeClickable(sonycomp));
		sonycomp.click();
	
	}
	
	public void iphoneclick () {
		//This Method Clicks on IPhone mobile Add to compare link.
		WebDriverWait wait = new WebDriverWait(driver,3);
		WebElement iphcomp = driver.findElement(compiphone);
		wait.until(ExpectedConditions.visibilityOf(iphcomp));
		iphcomp.click();
		
	}
	
	public void compclick () {
		//This method clicks on Compare button.
		WebElement btncompare = driver.findElement(compbtn);
		btncompare.click();
	}
	
	public void successmsg () {
		//This method displays the Success mesage when Mobile is added successfully to compare.
		WebElement scsmsg = driver.findElement(addmsg);
		String Addedmsg = scsmsg.getText();
		System.out.println(Addedmsg);
		
	}
	
	
	public void popupwindow () {
		//this method handles popup window.
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		
		while (i1.hasNext()) {
			
			String ChildWindow = i1.next();
			
			if(!MainWindow.equals(ChildWindow)) {
				
				driver.switchTo().window(ChildWindow);
				
				String poptitle = driver.getTitle();
				
				System.out.println(poptitle);
				
				
				List<WebElement> options = driver.findElements(compmob);
				for (WebElement item: options) {
					WebElement title = item.findElement(By.tagName("h2"));
					
					String mobnames =  title.getText();
					
					System.out.println("Mobiles to Compare : " +mobnames);
				
				}
	
					}
				
			}
		}

	///Test Case 5 Codes Starts from here
	
	
	
	public MobilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		MobilePage.driver = driver;
	}
	
	
	
}
