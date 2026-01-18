package testNGextent;

import org.testng.annotations.*;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reports.ExtentReportManager;

public class RegisterPage {
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

		testcase.info("Going to facebook.com");
		testcase.info("Fill the registration details");
		testcase.info("Create Account");
		testcase.pass("Account Created Successfully");
		Assert.assertEquals("HomePage", "HomePage");
		testcase.pass("Guest logged in sucessfully, Test Case is passed.");

	}
}
