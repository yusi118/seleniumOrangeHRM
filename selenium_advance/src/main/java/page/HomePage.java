package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverStrategy.DriverSingleton;
import utilities.Utils;

public class HomePage {

	private WebDriver driver;
	
	public HomePage() {
		driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="menu_pim_viewMyDetails")
	private WebElement myProfile;
	
	@FindBy(id="btnSave")
	private WebElement edit;
	
	@FindBy(id="personal_txtEmpFirstName")
	private WebElement firstName;
	
	@FindBy(id="personal_txtEmployeeId")
	private WebElement employeeId;
	
	public void modifyProfile() {
		myProfile.click();
		edit.click();
		firstName.sendKeys("Hector");
		employeeId.sendKeys("123");
		edit.click();
		WebDriverWait wait=new WebDriverWait(driver,15);
		WebElement mensaje=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fadable")));
		if(mensaje.getText().contains("Successfully")) {
			Utils.takeScreenshot();
			System.out.println("Mensaje es +++++++"+mensaje.getText());
			System.out.println("editado perfil ");
		}else {
			System.out.println("No mostrado mensaje");
		}
		
	}
	
	
}
