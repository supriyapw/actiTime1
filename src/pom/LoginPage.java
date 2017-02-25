package pom;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import generic.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="Username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login '")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//nobr[contains(.,'actiTime)]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errmsg;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	public void setusername(String un){
		unTB.sendKeys(un);	
	}
	public void setpassword(String pw){
		pwTB.sendKeys(pw);
	}
	public void clickLogin(){
		LoginBtn.click();
	}

	public void verifyversion(String eVersion){
		String aversion=version.getText();
		Assert.assertEquals(aversion, eVersion);
	}
	public void verifyerrispresent(SoftAssert s){
		 WebDriverWait wait=new WebDriverWait(driver,10);
		   try{
			   wait.until(ExpectedConditions.visibilityOf(errmsg));
			   Reporter.log("errmsg is displayed",true);
		   }catch(TimeoutException e){
			   Reporter.log("errmsg is not displayed",true);
			   s.fail();
		   }	
	}
}
