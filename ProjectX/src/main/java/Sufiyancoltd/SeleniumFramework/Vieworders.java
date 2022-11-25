package Sufiyancoltd.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import sufiyan.com.Abstract;

public class Vieworders extends Abstract {
	WebDriver driver;

	public Vieworders(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	

	
	@FindBy(xpath = "//td[2]")
	List<WebElement> orders;
	


	public boolean vieworderscompare(String products) {
		boolean yes = orders.stream().anyMatch(s -> s.getText().equalsIgnoreCase(products));
		
		return yes;
	}

	

}
