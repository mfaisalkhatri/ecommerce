package guru99.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	private static WebDriver driver;
	
	private static final By menu = By.cssSelector("#header-nav li");
	
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

	
	public MainPage(WebDriver  driver) {
		// TODO Auto-generated constructor stub
		
	this.driver = driver;
	}
	
}
