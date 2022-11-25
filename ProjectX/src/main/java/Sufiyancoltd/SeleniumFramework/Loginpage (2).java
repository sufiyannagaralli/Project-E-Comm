package Sufiyancoltd.SeleniumFramework;

import javax.swing.AbstractAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sufiyan.com.Abstract;

public class Loginpage extends Abstract {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		super(driver);

		this.driver = driver;

	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;
	@FindBy(css = ".ng-trigger-flyInOut")
	WebElement Error;

	public Productselect loginmethod(String emails, String passwords) {

		email.sendKeys(emails);
		password.sendKeys(passwords);
		login.click();
		Productselect obj = new Productselect(driver);
		return obj;

	}

	By error = By.cssSelector(".ng-trigger-flyInOut");

	public String getmeErrormessage() {
		VisibleOfElement(error);
		return Error.getText();

	}

	public void gotos() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}