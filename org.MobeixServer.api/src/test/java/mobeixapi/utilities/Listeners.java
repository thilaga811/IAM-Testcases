package mobeixapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import mobeixapi.base.base;

public class Listeners extends base implements ITestListener {

	// @Override
	public void onTestStart(ITestResult result) {
		System.out.println("Start Test");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " STARDED");
	}

	// @Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");

		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " SUCCESSED ");

	}

	// @Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Failed");

		test.log(LogStatus.FAIL, arg0.getMethod().getMethodName() + " !!!TEST IS FAILED!!!");
		/*
		 * String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new
		 * Date()); String destination = System.getProperty("user.dir") +
		 * "/FailedTestScreenShot/" + dateName + ".png"; File src =
		 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * try { FileUtils.copyFile(src, new File(destination)); String file =
		 * test.addScreenCapture(destination); test.log(LogStatus.FAIL,
		 * arg0.getMethod().getMethodName() + "test is failed", file);
		 * test.log(LogStatus.FAIL, arg0.getMethod().getMethodName() +
		 * "test is failed", arg0.getThrowable().getMessage()); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	// @Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");

		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " TEST IS SKIPPED");

	}

	// @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("50%");
	}

	// @Override
	public void onStart(ITestContext context) {
		System.out.println("First Start");

		reports = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport/Extend.html", true);
		// reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd
		// hh-mm-ss-ms").format(new Date()) + "reports.html");
		reports.addSystemInfo("Host Name", "MOBEIX_SERVER");
		reports.addSystemInfo("User Name", "ANBU");
		reports.addSystemInfo("Environment", "QA");
	}

	// @Override
	public void onFinish(ITestContext context) {
		System.out.println("Last Finish");

		reports.endTest(test);
		reports.flush();
	}

	int counter = 3, retryLimit = 3;

	public boolean retry(ITestResult result) {

		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}
