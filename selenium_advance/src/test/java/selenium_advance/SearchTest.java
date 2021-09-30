package selenium_advance;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import driverStrategy.DriverSingleton;
import page.DirectoryPage;
import page.LoginPage;
import utilities.Constants;
import utilities.FrameworkProperties;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTest {

	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static LoginPage loginPage;
	static DirectoryPage directoryPage;
	static Boolean expectedResult;
	static String inputString;
	
	@BeforeClass
	public static void initializeObjects() {
		frameworkProperties=new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		driver = DriverSingleton.getDriver();
		loginPage= new LoginPage();
		directoryPage=new DirectoryPage();
		driver.get(Constants.URL);
		loginPage.setUsernameAndPasswor(frameworkProperties.getProperty(Constants.USERNAME), frameworkProperties.getProperty(Constants.PASSWORD));
		loginPage.buttonLogin();
	}

	public SearchTest(String inputString, Boolean expectedResult) {
		this.inputString=inputString;
		this.expectedResult=expectedResult;
	}
	
	// la parameterized me permite introducir variables al test.
	// Es lo misma que la carga de datos (excell) de katalon 
	@Parameterized.Parameters
	public static Collection searchOptions() {
		return Arrays.asList(new Object [][]{
			{"Odis Adalwin", true},
			{"Peter Mac Anderson", true},
			{"Linda Jane Anderson", true},
			{"ff", false},
			{"test", false}});
	}
	@Test
	public void testingDirectory() {
		
		assertEquals(expectedResult,directoryPage.searchDirectory(inputString) );
	}
	
	
	@AfterClass
	public static void closeObject() {
		driver.close();
	}
	
}
