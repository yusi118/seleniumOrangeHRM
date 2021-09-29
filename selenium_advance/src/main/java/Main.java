import java.io.IOException;

import org.openqa.selenium.WebDriver;

import driverStrategy.DriverSingleton;
import page.HomePage;
import page.LoginPage;
import utilities.Constants;
import utilities.FrameworkProperties;

public class Main {

	public static void main(String [] args){
		FrameworkProperties frameworkProperties=new FrameworkProperties();
		DriverSingleton driverSingleton=DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
		WebDriver driver=DriverSingleton.getDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage loginPage=new LoginPage();
		loginPage.setUsernameAndPasswor(frameworkProperties.getProperty(Constants.USERNAME), 
				frameworkProperties.getProperty(Constants.PASSWORD));
		loginPage.buttonLogin();
		HomePage homePage=new HomePage();
		homePage.modifyProfile();
		
	}
}
