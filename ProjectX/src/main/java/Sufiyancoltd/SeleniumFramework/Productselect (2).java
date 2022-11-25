package Sufiyancoltd.SeleniumFramework;

import java.util.List;

import javax.swing.AbstractAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sufiyan.com.Abstract;

public class Productselect extends Abstract {

	WebDriver driver;

	public Productselect(WebDriver driver) {
		super(driver);

		this.driver = driver;

	}

	@FindBy(css = ".mb-3")
	List<WebElement> product;

	@FindBy(css = ".ng-animating ")
	WebElement waiting;
	@FindBy(css = "button[routerlink = '/dashboard/cart']")
	WebElement cartclick;

	By product1 = By.cssSelector(".mb-3");
	By product2 = By.cssSelector(".card-body button:last-of-type");
	By product3 = By.cssSelector("#toast-container");

	public List<WebElement> getproductlist() {
		VisibleOfElement(product1);
		return product;
	}

	public WebElement getproduct(String singleproduct) {
		WebElement con = getproductlist().stream()
				.filter(product1 -> product1.findElement(By.tagName("b")).getText().equals(singleproduct)).findFirst()
				.orElse(null);
		return con;
		
	}

	public void addtocart(String singleproduct) {
		WebElement con = getproduct(singleproduct);
		con.findElement(product2).click();
		VisibleOfElement(product3);
		inVisibleOfElement(waiting);

	}

}