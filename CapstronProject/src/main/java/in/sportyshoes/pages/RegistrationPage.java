package in.sportyshoes.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {

	
	
	
	
	@FindBy(css="body > div:nth-child(2) > form > a")
	private WebElement register;
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="email")
	private WebElement email;
	

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath="/html/body/div[2]/form/a")
	private WebElement registerbtn;


	
	
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void registerPage()
	{
		register.click();
	}
	
	public void EnterName()
	{
		name.sendKeys("Vikas");
	}
	
	public void EnterEmail() {
	   email.sendKeys("vikaskn721@gmail.com");
	}
	
	public void EnterPassword()
	{
		password.sendKeys("Vikas123");
	}
	
	public void clickRegisterBtn() throws InterruptedException
	{
		
		Thread.sleep(2000);
		registerbtn.click();
	}

}
