package guru99.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AcctCreation {

	private WebDriver driver;
	
	private static final By fname = By.cssSelector("#firstname");
	private static final By lname = By.cssSelector("#lastname");
	private static final By email = By.cssSelector("#email_address");
	private static final By passw = By.cssSelector ("#password");
	private static final By passconf = By.cssSelector("#confirmation");
	private static final By signchk = By.cssSelector("#is_subscribed");
	private static final By regbtn = By.xpath(".//*[@id='form-validate']/div[2]/button");
	private static final By smsg = By.cssSelector(".success-msg>ul>li>span");
	
	public void CreateAcct (String finame, String laname, String emailid, String pass1, String passcf) {
		WebElement firstname = driver.findElement(fname);
		firstname.clear();
		firstname.sendKeys(finame);
		
		WebElement lastname = driver.findElement(lname);
		lastname.clear();
		lastname.sendKeys(laname);
		
		WebElement emaill = driver.findElement(email);
		emaill.clear();
		emaill.sendKeys(emailid);
		
		WebElement password = driver.findElement(passw);
		password.clear();
		password.sendKeys(pass1);
		
		WebElement confpassword = driver.findElement(passconf);
		confpassword.clear();
		confpassword.sendKeys(passcf);
		
		WebElement signup = driver.findElement(signchk);
		signup.click();
		signup.click();
		
		WebElement Registerbtn = driver.findElement(regbtn);
		Registerbtn.click();
	
	}
	
	public void successmsg() {
		
		WebElement message = driver.findElement(smsg);
		String smsg = message.getText();
		Assert.assertEquals("Thank you for registering with Main Website Store.",smsg);
		System.out.println(smsg);
		
	}
	
	public AcctCreation(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}
}
