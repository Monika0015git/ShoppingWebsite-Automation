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

import base.BasePage;

public class Products extends BasePage {
	  private WebDriver driver;
	  private WebDriverWait wait;
	  private JavascriptExecutor js;
	  private Actions action;
	  
		@FindBy(xpath="//a[@href='#Women']")
		private WebElement womenPanel;
		@FindBy(xpath="//a[text()='Tops ']")
		private WebElement topsCategory;
		@FindBy(xpath="(//img[@alt='ecommerce website products'])[1]")
		private WebElement womenItem;
		@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'])[1]")
		private WebElement addToCartButton;
		@FindBy(xpath="//button[text()='Continue Shopping']")
		private WebElement continueShoppingButton;
		
		
		@FindBy(id="search_product")
		private WebElement searchBar;
		
		@FindBy(id="submit_search")
		private WebElement searchSumbit;
		
		@FindBy(xpath="//img[@alt='ecommerce website products']")
		private WebElement menItem;

		
		@FindBy(xpath="//u[text()='View Cart']")
		private WebElement viewCartLink;
		
		   public Products(WebDriver driver) 
		   {
			    this.driver = driver;
			    PageFactory.initElements(driver, this);
			    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			    js = (JavascriptExecutor) driver;    
			    action= new Actions(driver);

		    }
		   
     public void verifyProductsPage()
     {
       Assert.assertTrue(driver.getCurrentUrl().contains("products"));
       Reporter.log("The Products page is displayed");
     }
     public void addWomenItem() throws InterruptedException
     {
    	 wait.until(ExpectedConditions.visibilityOf(womenPanel));
    	 Assert.assertTrue(womenPanel.isDisplayed());
    	 womenPanel.click();
    	 Thread.sleep(2000);
    	 Reporter.log("Women panel is clicked ");
    	 
      	 wait.until(ExpectedConditions.visibilityOf(topsCategory));
    	 Assert.assertTrue(topsCategory.isDisplayed());
    	 topsCategory.click();
    	 Thread.sleep(2000);
    	 Reporter.log("Tops category is clicked ");
    	 
    	 wait.until(ExpectedConditions.visibilityOf(womenItem));
    	 Assert.assertTrue(womenItem.isDisplayed());
    	 action.moveToElement(womenItem).perform();
    	 Reporter.log("Women products under selected category are displayed ");
    	 addToCartButton.click();
    	 Thread.sleep(2000);
    	 Reporter.log("A product is added to the cart ");
    	 
     	 wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
    	 Assert.assertTrue(continueShoppingButton.isDisplayed());
    	 Reporter.log("Product added to the cart confirmation message is displayed");  
    	 Thread.sleep(2000);
    	 continueShoppingButton.click();
    	 Reporter.log("Continue Shopping button is clicked ");  
    	 
    		 
     }
     
     public void addMenItem() throws InterruptedException
     {
    	
    	
    	 wait.until(ExpectedConditions.visibilityOf(searchBar));
    	 Assert.assertTrue(searchBar.isDisplayed());
    	 searchBar.click();
    	 Thread.sleep(2000);
    	 Reporter.log("Search bar is clicked for searching men products");
    	 searchBar.sendKeys("Green Side Placket Detail T-Shirt");
    	 Thread.sleep(2000);
    	 searchSumbit.click();
    	 Thread.sleep(2000);
    	 Reporter.log("Input is entered into the search bar ");
    	 
       	 wait.until(ExpectedConditions.visibilityOf(menItem));
    	 Assert.assertTrue(menItem.isDisplayed());
    	 action.moveToElement(menItem).perform();
    	 Thread.sleep(2000);
    	 Reporter.log("Specified men product is displayed ");
    	 js.executeScript("arguments[0].scrollIntoView(true);",  addToCartButton);
    	 addToCartButton.click();
    	 Thread.sleep(2000);
    	 Reporter.log("Product is added to the cart ");
  
    	 wait.until(ExpectedConditions.visibilityOf(viewCartLink));
    	 Assert.assertTrue(viewCartLink.isDisplayed());
    	 Reporter.log("Product added to the cart confirmation message is displayed");  
    	 viewCartLink.click();    	 
    	 Thread.sleep(2000);
    	 Reporter.log("View Cart link is clicked ");  
    	 
     }

}
