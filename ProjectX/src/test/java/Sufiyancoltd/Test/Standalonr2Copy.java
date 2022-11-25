package Sufiyancoltd.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Sufiyancoltd.SeleniumFramework.Cartpage;
import Sufiyancoltd.SeleniumFramework.Loginpage;
import Sufiyancoltd.SeleniumFramework.PlaceOrder;
import Sufiyancoltd.SeleniumFramework.Productselect;
import Sufiyancoltd.SeleniumFramework.Vieworders;
import Sufiyancoltd.TestComponent.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;
import sufiyan.com.Abstract;

public class Standalonr2Copy extends Basetest {
	WebDriver driver;
	String products = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getdata", groups = { "Valid" })

	public void runAPP(HashMap<String, String> input) throws InterruptedException, IOException {

		Productselect obj = login.loginmethod(input.get("email"), input.get("password"));
		List<WebElement> product = obj.getproductlist();
		obj.addtocart((input.get("Product")));
		Cartpage cart = obj.clickCart();

		List<WebElement> list = cart.allElementinCart();
		boolean compare = cart.cartvaluescompare(input.get("Product"));
		Assert.assertTrue(compare);
		PlaceOrder obj2 = cart.checkout();
		obj2.input();
		obj2.ClickDroupdown();
		obj2.windowsScroll();
		Thread.sleep(2000);
		obj2.submit();
	}

	@Test(dependsOnMethods = { "runAPP" })
	public void vieworders() {
		Productselect obj = login.loginmethod("sufiyan@gmail.com", "Sufiyan123");
		Vieworders myorders = login.viewmyorders();
		boolean compare = myorders.vieworderscompare(products);
		Assert.assertTrue(compare);
	}

	@DataProvider
	public Object[][] getdata() throws IOException {
		List<HashMap<String, String>> data = jasondatagetter(
				"\\Users\\This PC\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\Sufiyancoltd\\data\\data.jason");
		
         return new Object[][] {{data.get(0)},{data.get(1)}};
	}// \Users\This PC\eclipse-workspace\SeleniumFramework\Users\This
		// PC\eclipse-workspace\SeleniumFramework\src\test\java\Sufiyancoltd\data\data.jason

}
/*
 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
 * "sufiyan@gmail.com"); map.put("password", "Sufiyan123");
 * map.put("productname", "ADIDAS ORIGINAL"); HashMap<String, String> map1 = new
 * HashMap<String, String>(); map1.put("email", "shetty@gmail.com");
 * map1.put("password", "Iamking@000"); map1.put("productname",
 * "IPHONE 13 PRO");
 */