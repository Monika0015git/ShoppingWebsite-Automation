package page;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.BasePage;

public class SingupLogin extends BasePage{
	   private WebDriver driver;
	    private WebDriverWait wait;
	    private JavascriptExecutor js;

@FindBy(xpath="//h2[text()='Login to your account']")
private WebElement loginHeader;
@FindBy(name="email")
private WebElement emailInputBox;
@FindBy(name="password")
private WebElement passwordInputBox;
@FindBy(xpath="//button[text()='Login']")
private WebElement loginButton;


public  SingupLogin(WebDriver driver) 
{
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    js = (JavascriptExecutor) driver; 

 }

public void verifyLoginPage()
{
	wait.until(ExpectedConditions.visibilityOf(loginHeader));
	Assert.assertTrue(loginHeader.isDisplayed());
	Reporter.log("Login page is displayed with header - "+loginHeader.getText());
}
public void login() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOf(emailInputBox));
	Assert.assertTrue(emailInputBox.isDisplayed());
	emailInputBox.sendKeys("sarahwheeler@test.com");
	Reporter.log("Email address is entered");
    Thread.sleep(2000);
    
	wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
	Assert.assertTrue(passwordInputBox.isDisplayed());
	passwordInputBox.sendKeys("sarah@2025#wheeler");
	Reporter.log("Password is entered");
    Thread.sleep(2000);
    
	wait.until(ExpectedConditions.visibilityOf(loginButton));
	Assert.assertTrue(loginButton.isDisplayed());
	loginButton.click();
	Reporter.log("Login button is clicked");
    Thread.sleep(2000);
    
}




}
