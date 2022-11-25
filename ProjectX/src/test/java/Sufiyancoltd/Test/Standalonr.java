package Sufiyancoltd.Test;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonr {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/client");
		String products = "ADIDAS ORIGINAL";
		driver.findElement(By.id("userEmail")).sendKeys("sufiyan@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sufiyan123");
		driver.findElement(By.id("login")).click();
		List<WebElement> pro = driver.findElements(By.cssSelector(".mb-3"));

		WebElement con = pro.stream().filter(product -> product.findElement(By.tagName("b")).getText().equals(products))
				.findFirst().orElse(null);

		con.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[routerlink = '/dashboard/cart']")).click();

		List<WebElement> list = driver.findElements(By.cssSelector(".cart h3"));
		boolean yes = list.stream().anyMatch(s -> s.getText().equalsIgnoreCase(products));
		Assert.assertTrue(yes);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.cssSelector("input[placeholder = 'Select Country']")).sendKeys("india");
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");

		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String a = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(a.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}

}