package generic;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {
   public WebDriver driver;
   public BasePage(WebDriver driver){
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   public void verifyTitle(String eTitle){
	   WebDriverWait wait=new WebDriverWait(driver,10);
	   try{
		   wait.until(ExpectedConditions.titleIs(eTitle));
		   Reporter.log("title is matching",true);
	   }catch(TimeoutException e){
		   Reporter.log("title is not matching",true);
		   Assert.fail();
	   }
	   
	   
	   
   }
   
}
