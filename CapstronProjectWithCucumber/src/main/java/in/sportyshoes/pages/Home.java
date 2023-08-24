package in.sportyshoes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	@FindBy(xpath="//*[@id=\"mynavbar\"]/ul/li[1]/a")
	private WebElement homebtn;
	
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void homebtn() {
		homebtn.click();
		
	}


}
