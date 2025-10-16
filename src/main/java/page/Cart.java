package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Cart {
	 private WebDriver driver;
	  private WebDriverWait wait;
	  private JavascriptExecutor js;
	  private Actions action;
	  
		  @FindBy(id="cart_info_table")
		  private WebElement cartTable;
		@FindBy(xpath="//td[@class='cart_description']")
		private List<WebElement> productsDescriptions;
		@FindBy(xpath="//a[text()='Proceed To Checkout']")
		private WebElement proceedToCheckoutButton;
		

		
		
	   public Cart(WebDriver driver) 
	   {
		    this.driver = driver;
		    PageFactory.initElements(driver, this);
		    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    js = (JavascriptExecutor) driver;    
		    action= new Actions(driver);

	    }
	     public void verifyCartPage()
	     {
	       Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
	       Reporter.log("The Cart page is displayed");
	     }
	     
	     public void verifyItems() throws InterruptedException
	     {
	    	 wait.until(ExpectedConditions.visibilityOf(cartTable));
	    	 Reporter.log("The cart contains the following products");
	    	 for(WebElement product:productsDescriptions)
	    	 {
	    		js.executeScript("arguments[0].scrollIntoView(true);",product);
	    		Thread.sleep(2000);
	    		 Reporter.log(product.getText());
	    		 Thread.sleep(2000);
	    	 }
	    	 
	     }
	     public void clickProceedToCheckout()
	     {
	    	 wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
	    	 Assert.assertTrue(proceedToCheckoutButton.isDisplayed());
	    	 proceedToCheckoutButton.click();
	    	 Reporter.log("Proceed To Checkout button is clicked ");
	     }

	   
}
