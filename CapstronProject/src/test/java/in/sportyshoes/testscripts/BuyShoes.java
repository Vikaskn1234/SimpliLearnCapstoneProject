package in.sportyshoes.testscripts;



import org.testng.Assert;
import org.testng.annotations.Test;

import in.sportyshoes.pages.AddtocartPage;
import in.sportyshoes.pages.Cart;
import in.sportyshoes.pages.Home;
import in.sportyshoes.pages.LoginPage;
import in.sportyshoes.pages.Palceorder;
import in.sportyshoes.pages.RegistrationPage;
import in.sportyshoes.pages.VerifyTitle;


public class BuyShoes extends BaseTest{

	@Test
	public void buyShoes() throws InterruptedException
	{
		RegistrationPage page=new RegistrationPage(driver);

		page.registerPage();
		page.EnterName();

		page.EnterEmail();

		page.EnterPassword();

		Thread.sleep(3000);
		page.clickRegisterBtn();

		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmail();
		loginpage.EnterPassword();
		loginpage.clickLoginBtn();



		AddtocartPage addtocart=new AddtocartPage(driver);
		//Thread.sleep(3000);

		addtocart.clickaddtocart();


		Home home=new Home(driver);
		home.homebtn();

		Cart cart=new Cart(driver);

		cart.cartbtn();

		Palceorder order=new Palceorder(driver);
		order.clickplaceorderbtn();

		VerifyTitle title=new VerifyTitle(driver);

		String expected="Message:Order Placed Successfully with ID: 10";
		String actual=title.verifyTitle();

		System.out.println(actual);
		//Assert.assertEquals(actual, expected);

	}


}
