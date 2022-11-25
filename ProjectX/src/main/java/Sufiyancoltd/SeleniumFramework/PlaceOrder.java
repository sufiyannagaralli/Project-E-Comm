package Sufiyancoltd.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import sufiyan.com.Abstract;

public class PlaceOrder extends Abstract {
	WebDriver driver;

	public PlaceOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(css = "input[placeholder = 'Select Country']")
	WebElement country;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement click;
	@FindBy(css = ".action__submit")
	WebElement submit;

	public void input() {
		country.sendKeys("india");
	}

	public void ClickDroupdown() {

		click.click();
	}

	public void windowsScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
	}

	public void submit() {
		submit.click();
	}
	

}