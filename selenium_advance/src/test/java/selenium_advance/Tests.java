package selenium_advance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import driverStrategy.DriverSingleton;
import page.HomePage;
import page.LoginPage;
import utilities.Constants;
import utilities.FrameworkProperties;
import utilities.Utils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// Ejecuta el teste de orden ascedente
public class Tests {

	// Es diferente la creacion de las variables en una clase normal como en junit. En este ultimo caso, 
	// necesitas declarar las variables como estaticos.
	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static HomePage homePage;
	static LoginPage loginPage;
	
	@BeforeClass
	public static void initializeObjects() {
		frameworkProperties=new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		driver = DriverSingleton.getDriver();
		homePage= new HomePage();
		loginPage= new LoginPage();
	}
	
	@Test
	public void testingLogin() {
		driver.get(Constants.URL);
		loginPage.setUsernameAndPasswor(frameworkProperties.getProperty(Constants.USERNAME), frameworkProperties.getProperty(Constants.PASSWORD));
		loginPage.buttonLogin();
	}
	
	@Test
	public void testingProfile() {
		homePage.modifyProfile();
		
	}
	@AfterClass
	public static void closeObject() {
		driver.close();
	}
	
}
