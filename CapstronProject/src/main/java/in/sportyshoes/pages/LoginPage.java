package in.sportyshoes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="email")
	private WebElement email;
	

	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(css="body > div:nth-child(2) > form > button")
	private WebElement loginbtn;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void EnterEmail() {
		   email.sendKeys("vikaskn721@gmail.com");
		}
		
		public void EnterPassword()
		{
			password.sendKeys("Vikas123");
		}
		
		public void clickLoginBtn()
		{
			loginbtn.click();
		}

}
