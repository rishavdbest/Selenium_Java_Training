package extentreport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReport {
	@Test
	public void sampleReport() {
		ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        spark.config().setDocumentTitle("My first Extent Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("My Sample Report");
        extent.attachReporter(spark);

       ExtentTest testcase = extent.createTest("FaceBook Login Page");
       testcase.info("Passing the Username");
       testcase.info("Passing the password");
       testcase.info("Logging in");
       testcase.pass("Guest logged in sucessfully, Test Case is passed.");
       
       ExtentTest testcase1 = extent.createTest("FaceBook Home Page");
       testcase1.info("Clicking on the profile picture");
       testcase1.info("Name is displayed");
       testcase1.info("Profile picture not updating");
       testcase1.fail("failed to fetch profile data, Test Case is failed.");

        extent.flush();
	}
}
