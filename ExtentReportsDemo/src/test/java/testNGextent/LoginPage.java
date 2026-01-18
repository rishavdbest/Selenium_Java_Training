package testNGextent;

import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentReportManager;

public class LoginPage {

	ExtentReports extent;
	ExtentTest testcase;

	@BeforeMethod
	public void init() {
		extent = ExtentReportManager.getReporter();
		testcase = extent.createTest("FaceBook Login Page");

	}

	@AfterMethod
	public void exit() {
		extent.flush();
	}

	@Test
	public void sampleReport() {

		testcase.info("Passing the Username");
		testcase.info("Passing the wrong password");
		testcase.info("Logging in");
		testcase.fail("Loggin failed");
		Assert.assertEquals("LoginPage", "HomePage");
		testcase.fail("Guest logged in sucessfully, Test Case is failed.");

	}
}