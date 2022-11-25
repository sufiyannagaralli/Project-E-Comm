package sufiyan.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Sufiyancoltd.SeleniumFramework.Cartpage;
import Sufiyancoltd.SeleniumFramework.Vieworders;

public class Abstract {
	WebDriver driver;

	public Abstract(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VisibleOfElement(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated((findby)));

	}

	public void inVisibleOfElement(WebElement find) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(find));
	}

	@FindBy(css = "button[routerlink = '/dashboard/cart']")
	WebElement cartclick;

	public Cartpage clickCart() {
		cartclick.click();
		Cartpage cart = new Cartpage(driver);
		return cart;
	}

	@FindBy(css = "i[class = 'fa fa-handshake-o']")
	WebElement ordersclick;

	public Vieworders viewmyorders() {
		ordersclick.click();
		Vieworders myorders = new Vieworders(driver);
		return myorders;
	}

}