package NikhitaJagota.Ecommerce.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {



	public static ExtentReports getExtentReporterObject() {
		 String path = System.getProperty("user.dir") + "//reports//index1.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Ecommerce Report");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Nikhita");

		return extent;
	}
}
