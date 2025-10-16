package test;
import org.testng.annotations.Test;
import base.BasePage;
import page.Cart;
import page.Checkout;
import page.Home;
import page.Payment;
import page.Products;
import page.SingupLogin;

public class EndToEndTesting  extends BasePage
{
	@Test(priority=1)
	public void launchApplication()
	{
		Home home= new Home(driver);
		home.verifyHomePage();
	}
	@Test(priority=2)
	public void login() throws InterruptedException
	{ 
		Home home = new Home(driver);
		SingupLogin  login = new SingupLogin (driver);
		home.clickSignupLogin();
		login.verifyLoginPage();
		login.login();
	}
	@Test(priority=3)
	public void shopProduct() throws InterruptedException 
	{ 
		Home home = new Home(driver);
        Products product = new Products(driver);
        Cart cart = new Cart(driver);
        
        home.clickProducts();
        product.verifyProductsPage();
        product.addWomenItem();
        home.clickProducts();
        product.addMenItem();
        
        cart.verifyCartPage();
        cart.verifyItems();
        cart.clickProceedToCheckout();
        
	}
	@Test(priority=4)
	public void proceedCheckout() throws InterruptedException
	{ 
	  Checkout checkout = new Checkout(driver);
      Payment pay = new Payment(driver);
      
      checkout.addComment();
      checkout.clickPlaceOrder();
      
      pay.verifyPaymentPage();
      pay.insertPaymentDetails();
      pay.verifyOrderePlaced();
       
	}
	@Test(priority=5)
	public void logout()
	{ 
	  Home home = new Home(driver);
	  home.clickLogout();
       
	}
	

}
