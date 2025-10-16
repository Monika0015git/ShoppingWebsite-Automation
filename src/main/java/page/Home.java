package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.BasePage;

public class Home extends BasePage{
	
	    private WebDriver driver;
	    private WebDriverWait wait;
	    
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	private WebElement logo;
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement home;
	@FindBy(xpath="//a[@href='/products']")
	private WebElement products;
	@FindBy(xpath="(//i[@class='fa fa-shopping-cart'])[1]")
	private WebElement cart;
	@FindBy(xpath="//i[@class='fa fa-lock']")
	private WebElement signupLogin;
	@FindBy(xpath="//i[@class='fa fa-envelope']")
	private WebElement contactUs;
	@FindBy(xpath="//a[@href='/logout']")
	private WebElement logout;
	

	   public Home(WebDriver driver) 
	   {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));     

	    }
	public void verifyHomePage()
	{
		wait.until(ExpectedConditions.visibilityOf(logo));
		Assert.assertTrue(logo.isDisplayed());
		Reporter.log("Application is launched successfully with logo");
	}
	public void clickSignupLogin()
	{
		wait.until(ExpectedConditions.visibilityOf(signupLogin));
		Assert.assertTrue(signupLogin.isDisplayed());
		signupLogin.click();
		Reporter.log("signup/Login link is clicked");
	}
	public void clickProducts()
	{
		wait.until(ExpectedConditions.visibilityOf(products));
		Assert.assertTrue(products.isDisplayed());
		products.click();
		Reporter.log("Products link is clicked");
	}
	public void clickCart()
	{
		wait.until(ExpectedConditions.visibilityOf(cart));
		Assert.assertTrue(cart.isDisplayed());
		cart.click();
		Reporter.log("Cart link is clicked");
	}
	public void clickLogout()
	{
		wait.until(ExpectedConditions.visibilityOf(logout));
		Assert.assertTrue(logout.isDisplayed());
		logout.click();
		Reporter.log("Logout link is clicked");
		Reporter.log("Successfully logged out from the account");
	}
	

}
