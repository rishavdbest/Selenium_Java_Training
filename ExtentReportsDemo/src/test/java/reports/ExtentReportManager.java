package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	public static ExtentReports extent;
	
	public static ExtentReports getReporter() {
		if(extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			spark.config().setDocumentTitle("FaceBook: Test Suite Report");
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("Integration test cases: Report");
			extent.attachReporter(spark);
		}
		
		return extent;
	}
}
