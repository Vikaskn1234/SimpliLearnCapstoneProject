package in.sportyshoes.teststeps;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import in.sportyshoes.pages.AddtocartPage;
import in.sportyshoes.pages.Cart;
import in.sportyshoes.pages.Home;
import in.sportyshoes.pages.LoginPage;
import in.sportyshoes.pages.Palceorder;
import in.sportyshoes.pages.VerifyTitle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyShoesSteps {
	WebDriver driver;
	@Given("a user is on the Register Page")
	public void a_user_is_on_the_register_page() {
		driver=new EdgeDriver();
		//2.maximize it
		driver.manage().window().maximize();
		
		//3. navigate to url
		driver.get("http://localhost:9010/");
	}
	    
	@Given("a user is on the Login Page")
	public void a_user_is_on_the_login_page() {
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmail();
		loginpage.EnterPassword();
		loginpage.clickLoginBtn();
	    
	}

	@When("he clicks a add to cart button")
	public void he_clicks_a_add_to_cart_button() throws InterruptedException {
		
		AddtocartPage addtocart=new AddtocartPage(driver);
		//Thread.sleep(3000);

		addtocart.clickaddtocart();
	    
	}

	@When("he clicks Home button")
	public void he_clicks_home_button() {
		Home home=new Home(driver);
		home.homebtn();
	}

	@When("he clicks CartButton")
	public void he_clicks_cart_button() {
       Cart cart=new Cart(driver);
		
		cart.cartbtn();
	    
	}

	@When("he clicks PlaceOrder button")
	public void he_clicks_place_order_button() throws InterruptedException {
		Palceorder order=new Palceorder(driver);
		order.clickplaceorderbtn();
	    
	}

	@Then("he must be able to purchase the mobile phone sucessfully.")
	public void he_must_be_able_to_purchase_the_mobile_phone_sucessfully() {
		
VerifyTitle title=new VerifyTitle(driver);
		
		String expected="Message:Order Placed Successfully with ID: 10";
		String actual=title.verifyTitle();
		
		System.out.println(actual);
	    
	}
}
