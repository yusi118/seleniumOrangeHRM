package automation.glue;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.config.RunFrameworkConfiguration;
import automation.driverStrategy.DriverSingleton;
import automation.page.HomePage;
import automation.page.LoginPage;
import automation.utilities.ConfigurationProperties;
import automation.utilities.Constants;
import automation.utilities.TestCases;
import automation.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@ContextConfiguration(classes=RunFrameworkConfiguration.class)
public class StepDefinition {

	static WebDriver driver; 
	static LoginPage loginPage;
	static HomePage homePage;
	ExtentTest test;
	static ExtentReports report=new  ExtentReports("report/TestReports.html");
	//con autowire no hace falta instanciarlo.
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void inicializedOBject() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		driver=DriverSingleton.getDriver();
		homePage= new HomePage();
		loginPage=new LoginPage();
		TestCases[] tests= TestCases.values();
		test=report.startTest(tests[Utils.testCount].getTestCase());
		Utils.testCount++;
	}
	
	@Given("I got to the Website") 
	public void i_go_to_the_Website() {
		inicializedOBject();
		driver.get(Constants.URL);
		test.log(LogStatus.PASS, "Navigating to "+Constants.URL);
	}
	
	@When("I specify my credentials")
	public void i_specify_my_credentials() {
		loginPage.setUsernameAndPasswor(configurationProperties.getUsername(),
				configurationProperties.getPassword());
		test.log(LogStatus.PASS, "the password and username have been introduced correctly");
	}
	@And("click login")
	public void click_login() {
		loginPage.buttonLogin();
		test.log(LogStatus.PASS, "Login button has been clicked");
	}
	
	@Then("I can log into the website")
	public void i_can_log_into_the_website() {
		homePage.modifyProfile();
		test.log(LogStatus.PASS, "Profile has been modified");
	}
	@After
	public void closedObjects() {
		report.endTest(test);
		report.flush(); // save the file to the disk
		DriverSingleton.closeObjectInstance();
	}
}
