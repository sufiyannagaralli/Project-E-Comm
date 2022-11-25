package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "sufiyan.StepDefnationdata", monochrome = true,tags = "@ErrorValidation", plugin = {"html:target/Cucumber.html" })
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
//C:\Users\This PC\eclipse-workspace\SeleniumFramework\src\test\java\cucumbere