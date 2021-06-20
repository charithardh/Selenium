package shopping;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import SampleMavenProject.SeleniumMavenProject.BaseTest;

public class AutomationShopping extends BaseTest{
	
	public static final Logger log=Logger.getLogger(ShoppingClass.class);
	public static String searchResultPageCost;
	public static String SearchDetailPageCost;
	public static String SearchDetailPageQuantity;
	public static String SearchDetailPageSize;
	public static String SearchDetailPageColour;
	public static String SearchConfirmPageCost;
	public static String SearchConfirmPageShipping;
	public static String SearchConfirmPageTotalCost;
	public static double ExpectedTotalCost;
	public static String SearchConfirmPageQuantity;
	public static String SearchConfirmPageColour;
	public static String SearchConfirmPageSize;
	

	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String browserType) throws Exception {
		init();
		test=report.startTest("AutomationShopping");
		resultInfo(log, "Loading the properties file.....!");
		
		launch(browserType);
		resultPass(log, "Launching Browser: "+browserType);

		deleteCookies();
		resultInfo(log, "Cleaned the Browser Cookies");
	
		navigateUrl("AutomationShoppingWebSite");
		resultPass(log, "Navigated to Following URL:"+childProp.getProperty("AutomationShoppingWebSite"));
	
		windowMaximize();
		resultInfo(log, "Window maximized");
		
	}
	
  @Test(priority = 1)
  public void searchResultsPage() throws Exception {
	  moveToElemant("womenWareTab_xpath");
		click("AttierType_xpath");
		resultPass(log, "Redirected to Search Results page");
		
		moveToElemant("itinarary_xpath");
		searchResultPageCost=getElementText("itinararyCost_xpath");
		resultInfo(log, "Cost of the shirt in search result page is :$"+searchResultPageCost);
		
		takeScreenshort();
		
		click("moreButton_xpath");
		resultPass(log, "Clicked on More Button");
		
		//Moving to the element to scroll down the webpage in Search Details page.
		moveToElemant("addToWishList_xpath");
		
		//Search Details page
		SearchDetailPageCost=getElementText("priceTag_xpath");
		resultInfo(log, "Search Details page cost: $"+SearchDetailPageCost);
		
		validation(log, searchResultPageCost, SearchDetailPageCost,"Cost in Search Result page($"+searchResultPageCost+") & Search Details($"+SearchDetailPageCost+") page are same ",
				"Cost in Search Result page($"+searchResultPageCost+") & Search Details($"+SearchDetailPageCost+") page are different ");
	
		SearchDetailPageQuantity=getFieldValue("clothQuantity_xpath", "value");
		resultInfo(log, "Quantity selected in the search Details page: "+SearchDetailPageQuantity);
		
		SearchDetailPageSize=getElementText("clothSize_xpath");
		resultInfo(log, "Size selected in Search Details page: "+SearchDetailPageSize);
		
		SearchDetailPageColour=getFieldValue("colour_xpath", "title");
		resultInfo(log, "Colour selected in Search Details page: "+SearchDetailPageColour);
		
		takeScreenshort();
		
		click("addToCartButton_xpath");
		resultPass(log, "Clicking on Add to Cart button");
		
		//Search confirm page
		Thread.sleep(3000);
		SearchConfirmPageCost=getElementText("searchConfiPageCost_xpath");
		resultInfo(log, "Search Confirm page cost: $"+SearchConfirmPageCost);
		
		validation(log, SearchDetailPageCost,SearchConfirmPageCost, "Cost in Search Detail page($"+SearchDetailPageCost+") & Search confirm($"+SearchConfirmPageCost+") page are same ",
				"Cost in Search Detail page($"+SearchDetailPageCost+") & Search confirm($"+SearchConfirmPageCost+") page are different ");
		
		SearchConfirmPageShipping=getElementText("searchConfiPageShipping_xpath");
		resultInfo(log, "Search Confirm page Shipping cost: $"+SearchConfirmPageShipping);
		
		SearchConfirmPageTotalCost=getElementText("searchConfiPageTotal_xpath");
		resultInfo(log, "Search Confirm page Total cost: $"+SearchConfirmPageTotalCost);
		
		ExpectedTotalCost=Double.parseDouble(SearchConfirmPageCost)+Double.parseDouble(SearchConfirmPageShipping);
		validation(log, Double.toString(ExpectedTotalCost), SearchConfirmPageTotalCost, "Expected($"+SearchConfirmPageCost+"+$"+SearchConfirmPageShipping+"=$"+ExpectedTotalCost+") & Actual($"+SearchConfirmPageTotalCost+") are equal",
				"Expected($"+SearchConfirmPageCost+"+$"+SearchConfirmPageShipping+"=$"+ExpectedTotalCost+") & Actual($"+SearchConfirmPageTotalCost+") are not equal");
		
		SearchConfirmPageQuantity=getElementText("searchConfiPageQuntity_xpath");
		validation(log, SearchDetailPageQuantity, SearchConfirmPageQuantity, "Quantity in Search Detail page("+SearchDetailPageQuantity+") & Search confirm("+SearchConfirmPageQuantity+") page are same ",
				"Quantity in Search Detail page("+SearchDetailPageQuantity+") & Search confirm("+SearchConfirmPageQuantity+") page are different ");
		
		
		String value=getElementText("SearchConfiPageColour_xpath");
		String[] words=value.split(",");
		SearchConfirmPageColour=words[0].trim();
		SearchConfirmPageSize=words[1].trim();
		
		validation(log, SearchDetailPageColour, SearchConfirmPageColour, "Colour in Search Detail page("+SearchDetailPageColour+") & Search confirm("+SearchConfirmPageColour+") page are same ",
				"Colour in Search Detail page("+SearchDetailPageColour+") & Search confirm("+SearchConfirmPageColour+") page are different ");
		
		
		validation(log, SearchDetailPageSize, SearchConfirmPageSize, "Size in Search Detail page("+SearchDetailPageSize+") & Search confirm("+SearchConfirmPageSize+") page are same ",
				"Size in Search Detail page("+SearchDetailPageSize+") & Search confirm("+SearchConfirmPageSize+") page are different ");
		
		takeScreenshort();
		
		click("checkout_xpath");
		resultPass(log, "Clicking on Proceed to checkout");
		
		//Confirmation Page
		moveToElemant("viewCart_xpath");
		
		click("removeCart_xpath");
		resultPass(log, "Removed From the cart");
		
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
		//windowClose();
	    resultInfo(log, "Closing the browser");
		report.endTest(test);
		report.flush();
	}
}
