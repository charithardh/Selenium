package SampleMavenProject.SeleniumMavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest{
     
	public static final Logger log=Logger.getLogger(TNG_002.class);
	
  @Test
  public void amazonlog4j() {
		selectOption("amazonSearchDropdown_id", "Books");
		log.info("Selecting the Dropdown using locator:" + orElemen.getProperty("amazonSearchDropdown_id"));
		typeText("mainSearchTextField_name", "Harry Potter");
		log.info("Entering the text using locator:" + orElemen.getProperty("mainSearchTextField_name"));
		click("mainSearchButton_xpath");
		log.info("Clicking on search button using locator:" + orElemen.getProperty("mainSearchButton_xpath"));
  }
  @BeforeMethod
  @Parameters("Browser")
  public void beforeMethod(String browserType) throws Exception {
		init();
		log.info("Loading the properties file.....!");
		launch(browserType);
		log.info("Launching the browser:" +browserType);
		deleteCookies();
		log.info("Deleting the browser cookies");
		navigateUrl("amazon");
		log.info("Navigating to the URL:" + childProp.getProperty("amazon"));
		windowMaximize();
  }

  @AfterMethod
  public void afterMethod() {
		windowClose();
		log.info("Closing the browser");
  }

}
