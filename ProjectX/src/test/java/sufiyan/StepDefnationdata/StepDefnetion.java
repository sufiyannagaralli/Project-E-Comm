package sufiyan.StepDefnationdata;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Sufiyancoltd.SeleniumFramework.Cartpage;
import Sufiyancoltd.SeleniumFramework.Loginpage;
import Sufiyancoltd.SeleniumFramework.PlaceOrder;
import Sufiyancoltd.SeleniumFramework.Productselect;
import Sufiyancoltd.Test.ErrorValidation;
import Sufiyancoltd.TestComponent.Basetest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefnetion extends Basetest {
	Loginpage login = new Loginpage(driver);
	public Productselect obj;
	public PlaceOrder obj2;
	public ErrorValidation error;
	// public List<WebElement> list;

	@Given("I  Landed On ECom Website Page")
	public void I_Landed_On_ECom_Website_Page() throws IOException {
		login = initializerdriver();
	}

	@Given("^Logged in with username(.+) and password(.+)$")
	public void Logged_in_with_username_and_password(String email, String passwords) {
		obj = login.loginmethod(email, passwords);

	}
	// Cannot invoke "Sufiyancoltd.SeleniumFramework.Loginpage.loginmethod(String,
	// String)" because "this.login" is null

	@When("^add product (.+) to cart$")
	public void add_product_to_cart(String productName) {
		List<WebElement> product = obj.getproductlist();
		obj.addtocart(productName);

	}

	// And Checkout <productName> and submit order
	@When("^Checkout (.+) and submit order$")
	public void Checkout_and_submit_order(String productName) throws InterruptedException {
		Cartpage cart = obj.clickCart();
		List<WebElement> list = cart.allElementinCart();
		boolean compare = cart.cartvaluescompare(productName);
		Assert.assertTrue(compare);
		obj2 = cart.checkout();
		obj2.input();
		obj2.ClickDroupdown();
		obj2.windowsScroll();
		Thread.sleep(2000);
		obj2.submit();

	}

	
	  @Then("^ \"([^\"]*)\" You should get invalid message $")
	public void you_should_get_invalid_message_something(String strArg1) throws Throwable {

		Assert.assertEquals(strArg1,login.getmeErrormessage() );
		System.out.println(strArg1);
	}

}
