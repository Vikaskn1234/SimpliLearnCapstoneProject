package in.sportyshoes.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtocartPage {
	Actions actions;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	@FindBy(xpath="/html/body/div[4]/div/div[6]/div/div/a")
	private WebElement addtocart;
	
	public AddtocartPage(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
		actions =new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
	}
	
	public void clickaddtocart()throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView()",addtocart);
		js.executeScript("arguments[0].click()",addtocart);
		
		
	}


}
