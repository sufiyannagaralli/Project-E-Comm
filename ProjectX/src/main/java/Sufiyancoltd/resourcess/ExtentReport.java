package Sufiyancoltd.resourcess;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports Extentreport() {
		String path = System.getProperty("user.dir") + "//report//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Automation Report");
		report.config().setDocumentTitle("Test.Teport");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Test Engineer Name", "Md Sufiyan Nagaralli");
		return extent;

	}

}