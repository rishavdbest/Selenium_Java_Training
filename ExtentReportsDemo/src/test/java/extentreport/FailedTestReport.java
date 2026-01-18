package extentreport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FailedTestReport {

	@Test
	public void sampleReport() {
		ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("full_testReport.html");
        spark.config().setDocumentTitle("Full Extent Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Full suite execution Displayed ");
        
        ExtentSparkReporter failedAndSkipped = new ExtentSparkReporter("failedSkip_testReport.html")
        		.filter().statusFilter()
        		.as(new Status[] {Status.FAIL, Status.SKIP})
        		.apply();
        
        failedAndSkipped.config().setDocumentTitle("Failed And Skipped Report");
        failedAndSkipped.config().setTheme(Theme.STANDARD);
        failedAndSkipped.config().setReportName("All Failed And Skipped Suite");
        extent.attachReporter(spark, failedAndSkipped);

       ExtentTest testcase = extent.createTest("FaceBook Login Page with correct password");
       testcase.info("Passing the Username");
       testcase.info("Passing the password");
       testcase.info("Logging in");
       testcase.pass("Guest logged in sucessfully, Test Case is passed.");
       
       ExtentTest testcase1 = extent.createTest("FaceBook Home Page");
       testcase1.info("Clicking on the home button");
       testcase1.info("Friends is displayed");
       testcase1.info("profiles picture being displayed");
       testcase1.pass("Able to see whole feed in the home page.");
       
       ExtentTest testcase2 = extent.createTest("FaceBook Login Page with incorrect password");
       testcase2.info("Passing the Username");
       testcase2.info("Passing incorrect password");
       testcase2.info("Logging in");
       testcase2.fail("Guest not able to  logged in, Test Case is failed.");
       
       ExtentTest testcase3 = extent.createTest("FaceBook Profile Page");
       testcase3.info("Clicking on the profile picture");
       testcase3.info("Name is displayed");
       testcase3.info("Profile picture not updating");
       testcase3.fail("failed to fetch profile data, Test Case is failed.");

       ExtentTest testcase4 = extent.createTest("FaceBook Follower List Page");
       testcase4.info("Clicking on the followers links");
       testcase4.info("Followers is displayed");
       testcase4.info("Follower total number section is displayed as string");
       testcase4.skip("follower number should be displayed as numbers , Test Case is skipped.");
        extent.flush();
	}
}
