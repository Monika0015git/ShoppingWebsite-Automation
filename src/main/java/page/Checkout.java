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

public class Checkout {
	 private WebDriver driver;
	  private WebDriverWait wait;
	  private JavascriptExecutor js;
	  private Actions action;
	  
		@FindBy(xpath="//a[text()='Place Order']")
		private WebElement placeOrderButton;
		@FindBy(name="message")
		private WebElement commentBox;
		
		
	   public Checkout(WebDriver driver) 
	   {
		    this.driver = driver;
		    PageFactory.initElements(driver, this);
		    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    js = (JavascriptExecutor) driver;    
		    action= new Actions(driver);

	    }
	     public void verifyCheckoutPage()
	     {
	       Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));
	       Reporter.log("The Checkout page is displayed");
	     }
	     
	     public void addComment() throws InterruptedException
	     {
	    	 js.executeScript("arguments[0].scrollIntoView(true);", commentBox);
	    		wait.until(ExpectedConditions.visibilityOf(commentBox));
	    		Assert.assertTrue(commentBox.isDisplayed());
	    		commentBox.sendKeys("Leave the package at the front door if no one is home.");
	    		Reporter.log("Additional instruction is provided through comment/message box");
	    	    Thread.sleep(2000);
	     }
	     
	     public void clickPlaceOrder() throws InterruptedException
	     {
	    	 js.executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
	    		wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
	    		Assert.assertTrue(placeOrderButton.isDisplayed());
	    		placeOrderButton.click();
	    		Thread.sleep(2000);
	    		Reporter.log("Place Order button is clicked");
	     }
	     

}
