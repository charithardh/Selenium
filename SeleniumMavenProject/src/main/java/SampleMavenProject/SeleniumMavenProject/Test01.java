package SampleMavenProject.SeleniumMavenProject;

import org.apache.log4j.Logger;

public class Test01 extends BaseTest{
	
	public static final Logger log=Logger.getLogger(Test01.class);

	public static void main(String[] args) throws Exception 
	{
        
		init();
		log.info("Loading the properties file.....!");
		launch("chromebrowser");
		log.info("Launching the browser:"+p.getProperty("chromebrowser"));
		deleteCookies();
		log.info("Deleting the browser cookies");
		navigateUrl("amazon");
		log.info("Navigating to the URL:"+childProp.getProperty("amazon"));
		windowMaximize();
		
		/*  String title = windowTitle(); 
		  System.out.println(title); 
		  String url=windowCurrentUrl(); System.out.println(url);*/
		 
		//windowBack();
		//waitForElement(5000);
		//windowForward();
		//waitForElement(7000);
		//windowRefresh();
		//windowClose();
		
		selectOption("amazonSearchDropdown_id", "Books");
		log.info("Selecting the Dropdown using locator:"+orElemen.getProperty("amazonSearchDropdown_id"));
		typeText("mainSearchTextField_name", "Harry Potter");
		log.info("Entering the text using locator:"+orElemen.getProperty("mainSearchTextField_name"));
		click("mainSearchButton_xpath");
		log.info("Clicking on search button using locator:"+orElemen.getProperty("mainSearchButton_xpath"));
		windowClose();
		log.info("Closing the browser");

	}

}
