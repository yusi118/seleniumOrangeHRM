package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverStrategy.DriverSingleton;
import utilities.Utils;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage {
	private WebDriver driver;
	public LoginPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtUsername") 
	private WebElement  INPUT_USERNAME;
	
	@FindBy(id="txtPassword")
	private WebElement  INPUT_PASSWORD;
	
	@FindBy(id="btnLogin")
	private WebElement LOGIN_BUTTON;
	
	public void buttonLogin() {
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
		LOGIN_BUTTON.click();
		
	}
	
	public void setUsernameAndPasswor(String username, String password) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(INPUT_USERNAME));
		INPUT_USERNAME.sendKeys(username);
		
		wait.until(ExpectedConditions.elementToBeClickable(INPUT_PASSWORD));
		INPUT_PASSWORD.sendKeys(password);
		
	}

}
