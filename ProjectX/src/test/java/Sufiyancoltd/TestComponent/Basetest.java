package Sufiyancoltd.TestComponent;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Sufiyancoltd.SeleniumFramework.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;

	public Loginpage login;

	public WebDriver components() throws IOException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				"\\Users\\This PC\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\Sufiyancoltd\\resourcess\\global.txt");
		pro.load(fis);
		String browsername = pro.getProperty("browser");
		System.out.println(browsername);

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\This PC\\OneDrive\\Desktop\\File\\geckodriver-v0.31.0-win64");
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\This PC\\OneDrive\\Desktop\\File\\edgedriver_win64");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public Loginpage initializerdriver() throws IOException {
		driver = components();
		login = new Loginpage(driver);
		login.gotos();
		return login;
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}

	public List<HashMap<String, String>> jasondatagetter(String filepath) throws IOException {

		String jasoncon = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jasoncon,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public static String takeScreenShot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File of = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//report//" + testcasename + ".png");
		FileUtils.copyFile(of, file);
		return System.getProperty("user.dir") + "//report//" + testcasename + ".png";
	}

}