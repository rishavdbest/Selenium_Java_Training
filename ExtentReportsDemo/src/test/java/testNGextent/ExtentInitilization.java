package testNGextent;

import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentInitilization {
	ExtentReports extent;
	ExtentTest testcase;
	ExtentTest testcase1;

	@BeforeMethod
	public void init() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		spark.config().setDocumentTitle("FaceBook: Test Suite Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Integration test cases: Report");
		extent.attachReporter(spark);
		testcase = extent.createTest("FaceBook Login Page");
		testcase1 = extent.createTest("FaceBook Home Page");

	}

	@AfterMethod
	public void exit() {
		extent.flush();
	}

	@Test
	public void sampleReport() {
		testcase1.info("Clicking on the profile picture");
		testcase1.info("Name is displayed");
		testcase1.info("Profile picture updating");
		testcase1.pass("fetched profile data, Test Case is passed.");

		testcase.info("Passing the Username");
		testcase.info("Passing the wrong password");
		testcase.info("Logging in");
		testcase.fail("Loggin failed");
		Assert.assertEquals("HomePage", "LoginPage");
		testcase.fail("Guest logged in sucessfully, Test Case is passed.");

	}
}
