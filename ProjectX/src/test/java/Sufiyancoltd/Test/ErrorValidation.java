package Sufiyancoltd.Test;

import java.io.IOException;
import java.time.Duration;
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
import org.testng.annotations.Test;

import Sufiyancoltd.SeleniumFramework.Cartpage;
import Sufiyancoltd.SeleniumFramework.Loginpage;
import Sufiyancoltd.SeleniumFramework.PlaceOrder;
import Sufiyancoltd.SeleniumFramework.Productselect;
import Sufiyancoltd.TestComponent.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;
import sufiyan.com.Abstract;

public class ErrorValidation extends Basetest {
	WebDriver driver;

	@Test(groups = { "Error" })
	public void runAPP() throws InterruptedException, IOException {
		String products = "ADIDAS ORIGINAL";

		Productselect obj = login.loginmethod("sufiyan@gmaill.com", "Sufiyan12345");

		Assert.assertEquals(login.getmeErrormessage(), "Incorrect email or password.");
		String text = login.getmeErrormessage();
		System.out.println(text);

	}
}