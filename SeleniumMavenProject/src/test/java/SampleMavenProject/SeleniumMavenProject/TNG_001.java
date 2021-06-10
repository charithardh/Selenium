package SampleMavenProject.SeleniumMavenProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class TNG_001 extends BaseTest {
  @Test
  public void amazon() throws Exception {
		String expectedText = "Customer service";
		if (verifyLinkEqualsTo(expectedText)) {
			VerificationPassed("Link text are equal");
		    System.out.println("Link text are equal");
		}
		else {
			VerificationFailed("Link text are not equal");
			System.out.println("Link text are not equal");
		}
		selectOption("amazonSearchDropdown_id", "Books");
		test.log(LogStatus.PASS, "Selecting the Dropdown using locator:"+orElemen.getProperty("amazonSearchDropdown_id"));
		typeText("mainSearchTextField_name", "Harry Potter");
		test.log(LogStatus.PASS, "Entering the text using locator:"+orElemen.getProperty("mainSearchTextField_name"));
		click("mainSearchButton_xpath");
		test.log(LogStatus.PASS, "Clicking on search button using locator:"+orElemen.getProperty("mainSearchButton_xpath"));
  }
  @BeforeMethod
  @Parameters("Browser")
  public void beforeMethod(String browserType) throws Exception {
	    init();
		test=report.startTest("TNG_001");
		test.log(LogStatus.INFO, "Loading the properties file.....!");
		launch(browserType);
		test.log(LogStatus.PASS, "Launching the browser:"+browserType);
		deleteCookies();
		test.log(LogStatus.INFO, "Deleting the browser cookies");
		navigateUrl("amazon");
		test.log(LogStatus.PASS, "Navigating to the URL:"+childProp.getProperty("amazon"));
		windowMaximize();
		test.log(LogStatus.INFO, "Browser got maximized");
  }

  @AfterMethod
  public void afterMethod() {
	    windowClose();
		test.log(LogStatus.INFO, "Closing the browser");
		report.endTest(test);
		report.flush();
  }

}
