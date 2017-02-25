package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class EnterTimeTrackpage extends BasePage {
    @FindBy(id="LogoutLink")
    private WebElement LogoutLink;
	public EnterTimeTrackpage(WebDriver driver) {
		super(driver);
		
	}
	public void clickLogout(){
		LogoutLink.click();
	}

}
