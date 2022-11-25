package Sufiyancoltd.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import sufiyan.com.Abstract;

public class Cartpage extends Abstract {
	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(css = ".cart h3")
	List<WebElement> list;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement click;

	public List<WebElement> allElementinCart() {
		return list;

	}

	public boolean cartvaluescompare(String products2) {
		boolean yes = list.stream().anyMatch(s -> s.getText().equalsIgnoreCase(products2));

		return yes;
	}

	public PlaceOrder checkout() {
		click.click();
		PlaceOrder obj2 = new PlaceOrder(driver);
		return obj2;
	}

}
