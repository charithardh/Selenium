package listenerPackage;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import SampleMavenProject.SeleniumMavenProject.BaseTest;

public class Listener extends BaseTest implements ITestListener{
            
	public void onTestStart(ITestResult result) {
		Reporter.log("Test Execution started:" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.isSuccess()) {
			try {
				File screnshrt = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screnshrt, new File(projectPath + "//success//" + fileName + ".png"));

				Reporter.log("<a href='" + projectPath + "//success//" + fileName + ".png" + "'><img src='"
						+ projectPath + "//success//" + fileName + ".png" + "' height='100' width='100'/></a>");
				Reporter.log("Test Executed Successfully:" + result.getMethod().getMethodName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult result) {
		if (!result.isSuccess()) {
			try {
				File screnshrt2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screnshrt2, new File(projectPath + "//Failure//" + fileName + ".png"));

				Reporter.log("<a href='" + projectPath + "//Failure//" + fileName + ".png" + "'><img src='"
						+ projectPath + "//Failure//" + fileName + ".png" + "' height='100' width='100'/></a>");
				Reporter.log("Test Execution Failed:" + result.getMethod().getMethodName());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Execution Skipped:" + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}
}
