package page;

import java.time.Duration;

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

public class Payment {
	 private WebDriver driver;
	  private WebDriverWait wait;
	  private JavascriptExecutor js;
	  private Actions action;
	  
		@FindBy(name="name_on_card")
		private WebElement nameOnTheCardInputBox;
		@FindBy(name="card_number")
		private WebElement cardNumberInputBox;
		@FindBy(name="cvc")
		private WebElement cvvInputBox;
		@FindBy(name="expiry_month")
		private WebElement expiryMonthInputBox;
		@FindBy(name="expiry_year")
		private WebElement expiryYearInputBox;
		@FindBy(id="submit")
		private WebElement payAndConfirmOrderButton;
		@FindBy(xpath="//a[text()='Continue']")
		private WebElement continueButton;
		@FindBy(xpath="	//p[@style='font-size: 20px; font-family: garamond;']")
		private WebElement congratulationsMessage;

	

		
		
	   public Payment(WebDriver driver) 
	   {
		    this.driver = driver;
		    PageFactory.initElements(driver, this);
		    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    js = (JavascriptExecutor) driver;    
		    action= new Actions(driver);

	    }
	     public void verifyPaymentPage()
	     {
	       Assert.assertTrue(driver.getCurrentUrl().contains("payment"));
	       Reporter.log("The Payment page is displayed");
	     }
	     
	     public void insertPaymentDetails() throws InterruptedException
	     {
	    	 wait.until(ExpectedConditions.visibilityOf(nameOnTheCardInputBox));
	    	Assert.assertTrue(nameOnTheCardInputBox.isDisplayed());
	    	nameOnTheCardInputBox.sendKeys("SARAH WHEELER");
	    	Reporter.log("Name on the is provided");
	    	Thread.sleep(2000);
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(cardNumberInputBox));
	    	Assert.assertTrue(cardNumberInputBox.isDisplayed());
	    	cardNumberInputBox.sendKeys("1001200230034004");
	    	Reporter.log("Card number is provided");
	    	Thread.sleep(2000);
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(cvvInputBox));
	    	Assert.assertTrue(cvvInputBox.isDisplayed());
	    	cvvInputBox.sendKeys("999");
	    	Reporter.log("CVV is provided");
	    	Thread.sleep(2000);
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(expiryMonthInputBox));
	    	Assert.assertTrue(expiryMonthInputBox.isDisplayed());
	    	expiryMonthInputBox.sendKeys("01");
	    	Reporter.log("Expiry Month is provided");
	    	Thread.sleep(2000);
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(expiryYearInputBox));
	    	Assert.assertTrue(expiryYearInputBox.isDisplayed());
	    	expiryYearInputBox.sendKeys("2040");
	    	Reporter.log("Expiry Year is provided");
	    	Thread.sleep(2000);
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(payAndConfirmOrderButton));
	    	Assert.assertTrue(payAndConfirmOrderButton.isDisplayed());
	    	payAndConfirmOrderButton.click();
	    	Reporter.log("Pay And Confirm Order Button is clicked");
	    	Thread.sleep(2000);
	     }
	     
	     public void verifyOrderePlaced()
	     {
	    	 wait.until(ExpectedConditions.visibilityOf(congratulationsMessage));
	    	Assert.assertTrue(congratulationsMessage.isDisplayed());	    	
	    	Reporter.log("Order is placed successfully with message displayed on the screen as:"+congratulationsMessage.getText());
	    	
	    	 wait.until(ExpectedConditions.visibilityOf(continueButton));
	    	Assert.assertTrue(continueButton.isDisplayed());
	    	continueButton.click();
	    	Reporter.log("Continue button is clciked");
	     }

}
