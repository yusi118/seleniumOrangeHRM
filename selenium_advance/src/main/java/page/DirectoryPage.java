package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverStrategy.DriverSingleton;
import utilities.Utils;

public class DirectoryPage {

	private WebDriver driver;
	
	public DirectoryPage() {
		driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="menu_directory_viewDirectory")
	private WebElement directory;
	
	@FindBy(id="searchDirectory_emp_name_empName")
	private WebElement searchName;
	
	@FindBy(id="searchBtn")
	private WebElement searchButton;
	
	@FindBy(css="#resultTable > tbody > tr:nth-child(2) > td:nth-child(2) > ul > li:nth-child(1) > b")
	private WebElement searchResult;
	
	public boolean searchDirectory(String name) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(directory));
		directory.click();
		searchName.sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		try {
			if(searchResult.isDisplayed())
				return true;
		}catch(Exception e) {
			return false;
		}
		return false;
	}
}
