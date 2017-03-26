package guru99.ecommerce.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	private static WebDriver driver;
	
	private static final By menu = By.cssSelector("#header-nav li");
	private static final By actlink = By.linkText("MY ACCOUNT");
	private static final By creatAct = By.xpath(".//*[@id='login-form']/div/div[1]/div[2]/a/span/span");
	
	public WebElement headerItems (String items) {
		List<WebElement> options = driver.findElements(menu);
		for (WebElement item: options) {
			WebElement title = item.findElement(By.linkText(items));
			if(title.getText().equals(items)) {
				return item;
			}
		}
		return null;
	}

	
	public void MyActclick() {
		WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(actlink));
		wait.click();
		
	}
	
	public void windowhandlechange () {
		
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
	}
	
	public void CreateAct () {
		WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(creatAct));
		wait.click();
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public MainPage(WebDriver  driver) {
		// TODO Auto-generated constructor stub
		
	this.driver = driver;
	}
	
}
