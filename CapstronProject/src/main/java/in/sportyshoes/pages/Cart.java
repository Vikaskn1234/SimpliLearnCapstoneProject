package in.sportyshoes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	
	@FindBy(xpath="//*[@id=\"mynavbar\"]/ul/li[1]/a")
	private WebElement cartbtn;
	
	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	public void cartbtn() {
		cartbtn.click();
	}


}
