package shopping;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import SampleMavenProject.SeleniumMavenProject.BaseTest;

public class ShoppingClass extends BaseTest{
	
	public static final Logger log=Logger.getLogger(ShoppingClass.class);
	public static String searchResultPageCost;
	public static String SearchDetailPageCost;
	public static String SearchDetailPageQuantity;
	public static String SearchDetailPageSize;
	public static String SearchDetailPageColour;
	public static String SearchConfirmPageCost;
	public static String SearchConfirmPageShipping;
	public static String SearchConfirmPageTotalCost;
	public static String ExpectedTotalCost;
	public static String SearchConfirmPageQuantity;
	public static String SearchConfirmPageColour;
	public static String SearchConfirmPageSize;

	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String browserType) throws Exception {
		init();
		test=report.startTest("TC_003");
		log.info("Loading the properties file.....!");
		test.log(LogStatus.INFO, "Loading the properties file.....!");
		launch(browserType);
		log.info("Launching Browser: "+browserType);
		test.log(LogStatus.PASS, "Launching the browser:"+browserType);
		deleteCookies();
		log.info("Cleaned the Browser Cookies");
		test.log(LogStatus.INFO, "Cleaning the browser Cookies");
		navigateUrl("AutomationShoppingWebSite");
		log.info("Navigated to Following URL:"+childProp.getProperty("AutomationShoppingWebSite"));
		test.log(LogStatus.PASS, "Navigating to the URL:"+childProp.getProperty("AutomationShoppingWebSite"));
		windowMaximize();
		log.info("Window maximized");
		test.log(LogStatus.INFO, "Browser got maximized");
	}

	@Test
	public void shopping() throws Exception {
		moveToElemant("womenWareTab_xpath");
		click("AttierType_xpath");
		log.info("Redirected to Search Results page");
		test.log(LogStatus.PASS, "Redirected to Search Results page");
		
		moveToElemant("itinarary_xpath");
		searchResultPageCost=getElementText("itinararyCost_xpath");
		log.info("Cost of the shirt in search result page is :"+searchResultPageCost);
		test.log(LogStatus.INFO, "Cost of the shirt in search results page: "+searchResultPageCost);
		
		click("moreButton_xpath");
		log.info("Clicked on More Button");
		test.log(LogStatus.PASS, "Clicked on More Button");
		
		//Moving to the element to scroll down the webpage in Search Details page.
		moveToElemant("addToWishList_xpath");
		
		//Search Details page
		SearchDetailPageCost=getElementText("priceTag_xpath");
		log.info("Search Details page cost: "+SearchDetailPageCost);
		test.log(LogStatus.INFO, "Search Details page cost: "+SearchDetailPageCost);
		
		if(searchResultPageCost.replace("$", "").equals(SearchDetailPageCost.replace("$", ""))) {
			log.info("Cost in Search Result page("+searchResultPageCost+") & Search Details("+SearchDetailPageCost+") page are same ");
			VerificationPassed("Cost in Search Result page("+searchResultPageCost+") & Search Details("+SearchDetailPageCost+") page are same ");
		}else {
			log.info("Cost in Search Result page("+searchResultPageCost+") & Search Details("+SearchDetailPageCost+") page are different ");
			VerificationFailed("Cost in Search Result page("+searchResultPageCost+") & Search Details("+SearchDetailPageCost+") page are different ");
		}
		
		SearchDetailPageQuantity=getFieldValue("clothQuantity_xpath", "value");
		log.info("Quantity selected in the search Details page: "+SearchDetailPageQuantity);
		test.log(LogStatus.INFO, "Quantity selected in the search Details page: "+SearchDetailPageQuantity);
		
		SearchDetailPageSize=getElementText("clothSize_xpath");
		log.info("Size selected in Search Details page: "+SearchDetailPageSize);
		test.log(LogStatus.INFO, "Size selected in Search Details page: "+SearchDetailPageSize);
		
		SearchDetailPageColour=getFieldValue("colour_xpath", "title");
		log.info("Colour selected in Search Details page: "+SearchDetailPageColour);
		test.log(LogStatus.INFO, "Colour selected in Search Details page: "+SearchDetailPageColour);
		
		click("addToCartButton_xpath");
		log.info("Clicking on Add to Cart button");
		test.log(LogStatus.PASS, "Clicking on Add to Cart button");
		
		//Search confirm page
		Thread.sleep(3000);
		SearchConfirmPageCost=getElementText("searchConfiPageCost_xpath");
		log.info("Search Confirm page cost: "+SearchConfirmPageCost);
		test.log(LogStatus.INFO, "Search Confirm page cost: "+SearchConfirmPageCost);
		
		if(SearchDetailPageCost.replace("$", "").equals(SearchConfirmPageCost.replace("$", ""))) {
			log.info("Cost in Search Detail page("+SearchDetailPageCost+") & Search confirm("+SearchConfirmPageCost+") page are same ");
			VerificationPassed("Cost in Search Detail page("+SearchDetailPageCost+") & Search confirm("+SearchConfirmPageCost+") page are same ");
		}else {
			log.info("Cost in Search Detail page("+SearchDetailPageCost+") & Search confirm("+SearchConfirmPageCost+") page are different ");
			VerificationFailed("Cost in Search Detail page("+SearchDetailPageCost+") & Search confirm("+SearchConfirmPageCost+") page are different ");
		}
		
		SearchConfirmPageShipping=getElementText("searchConfiPageShipping_xpath");
		log.info("Search Confirm page Shipping cost: "+SearchConfirmPageShipping);
		test.log(LogStatus.INFO, "Search Confirm page Shipping cost: "+SearchConfirmPageShipping);
		
		SearchConfirmPageTotalCost=getElementText("searchConfiPageTotal_xpath");
		log.info("Search Confirm page Total cost: "+SearchConfirmPageTotalCost);
		test.log(LogStatus.INFO, "Search Confirm page Total cost: "+SearchConfirmPageTotalCost);
		
		ExpectedTotalCost=SearchConfirmPageCost.replace("$", "")+SearchConfirmPageShipping.replace("$", "");
		if(ExpectedTotalCost.equals(SearchConfirmPageTotalCost)) {
			log.info("Expected("+SearchConfirmPageCost+"+"+SearchConfirmPageShipping+"=$"+ExpectedTotalCost+") & Actual("+SearchConfirmPageTotalCost+") are equal");
			VerificationPassed("Expected("+SearchConfirmPageCost+"+"+SearchConfirmPageShipping+"=$"+ExpectedTotalCost+") & Actual("+SearchConfirmPageTotalCost+") are equal");
		}else {
			log.info("Expected("+SearchConfirmPageCost+"+"+SearchConfirmPageShipping+"=$"+ExpectedTotalCost+") & Actual("+SearchConfirmPageTotalCost+") are not equal");
			VerificationFailed("Expected("+SearchConfirmPageCost+"+"+SearchConfirmPageShipping+"=$"+ExpectedTotalCost+") & Actual("+SearchConfirmPageTotalCost+") are not equal");
		}
		
		SearchConfirmPageQuantity=getElementText("searchConfiPageQuntity_xpath");
		if(SearchDetailPageQuantity.equals(SearchConfirmPageQuantity)) {
			log.info("Quantity in Search Detail page("+SearchDetailPageQuantity+") & Search confirm("+SearchConfirmPageQuantity+") page are same ");
			VerificationPassed("Quantity in Search Detail page("+SearchDetailPageQuantity+") & Search confirm("+SearchConfirmPageQuantity+") page are same ");
		}else {
			log.info("Quantity in Search Detail page("+SearchDetailPageQuantity+") & Search confirm("+SearchConfirmPageQuantity+") page are different ");
			VerificationFailed("Quantity in Search Detail page("+SearchDetailPageQuantity+") & Search confirm("+SearchConfirmPageQuantity+") page are different ");
		}
		
		String value=getElementText("SearchConfiPageColour_xpath");
		String[] words=value.split(",");
		SearchConfirmPageColour=words[0].trim();
		SearchConfirmPageSize=words[1].trim();
		
		if(SearchDetailPageColour.equals(SearchConfirmPageColour)) {
			log.info("Colour in Search Detail page("+SearchDetailPageColour+") & Search confirm("+SearchConfirmPageColour+") page are same ");
			VerificationPassed("Colour in Search Detail page("+SearchDetailPageColour+") & Search confirm("+SearchConfirmPageColour+") page are same ");
		}else {
			log.info("Colour in Search Detail page("+SearchDetailPageColour+") & Search confirm("+SearchConfirmPageColour+") page are different ");
			VerificationFailed("Colour in Search Detail page("+SearchDetailPageColour+") & Search confirm("+SearchConfirmPageColour+") page are different ");
		}
		
		if(SearchDetailPageSize.equals(SearchConfirmPageSize)) {
			log.info("Size in Search Detail page("+SearchDetailPageSize+") & Search confirm("+SearchConfirmPageSize+") page are same ");
			VerificationPassed("Size in Search Detail page("+SearchDetailPageSize+") & Search confirm("+SearchConfirmPageSize+") page are same ");
		}else {
			log.info("Size in Search Detail page("+SearchDetailPageSize+") & Search confirm("+SearchConfirmPageSize+") page are different ");
			VerificationFailed("Size in Search Detail page("+SearchDetailPageSize+") & Search confirm("+SearchConfirmPageSize+") page are different ");
		}
		
		click("checkout_xpath");
		log.info("Clicking on Proceed to checkout");
		test.log(LogStatus.PASS, "Proceed to checkout");
	}

	@AfterMethod
	public void afterMethod() {
		//windowClose();
		log.info("Closing the browser");
		test.log(LogStatus.INFO, "Closing the browser");
		report.endTest(test);
		report.flush();
	}
}
