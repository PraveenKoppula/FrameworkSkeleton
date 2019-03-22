package projectName_Testing;

import java.io.IOException;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectName_Pages.HeaderPage;
import projectName_Utils.InvokingBrowser;

public class AmazonHeader extends InvokingBrowser{
	HeaderPage headerPage;
	JavascriptExecutor js;
	public static Logger log= LogManager.getLogger(AmazonHeader.class.getName());
	
	@BeforeTest
	public void init() throws IOException
	{
		driver=initializeDriver();
		headerPage = new HeaderPage(driver);
		js = (JavascriptExecutor) driver;
		log.info("Header Initializations done");
	}
	
	@Test
	public void CheckAmazonLogoInHeader() throws IOException
	{		
		int countOfElements = headerPage.AmazonLogoPresense().size();
		Assert.assertEquals(countOfElements, 1,"Amazon logo MISSING in Header");
		log.info("Amazon logo is present in Header");
	}
	
	@Test
	public void SearchToysAndGames() throws IOException
	{		
		Select searchDropdown = new Select(headerPage.SearchDropdownBox());
		searchDropdown.selectByValue("search-alias=toys-and-games");
		headerPage.SearchBox().sendKeys("kitchen set");
		headerPage.SearchButton().click();
		log.info("kitchen set entered in text box and seach button is clicked");
	}

	@Test (dependsOnMethods = "SearchToysAndGames")
	public void InputPriceRange() throws IOException, InterruptedException
	{		
		headerPage.MinimumPrice().sendKeys("20");
		headerPage.MaximumPrice().sendKeys("50");
		Thread.sleep(5000);
		headerPage.PriceGoButton().click();
		log.info("Min and max price entered and clicked Go button");
		
		log.info("Count of Results displayed : " +headerPage.ResultsList().size());
			
//		for(WebElement el:headerPage.ResultsList())
//		{
//			log.info(el.getText());
//		}
	}
	
	
	@Test (dependsOnMethods = "InputPriceRange")
	public void ClickAmazonLogoInHeader() throws IOException
	{		
//		js.executeScript("arguments[0].scrollIntoView();", headerPage.NextPageButton());
//		headerPage.NextPageButton().click();
//		log.info("Screen scrolled to the bottom and Next button is clicked");
		headerPage.AmazonLogo().click();
		log.info("Amazon logo clicked");
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{		
		driver.close();
		driver = null;
	}
	
}
