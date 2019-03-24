package projectName_Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectName_Pages.FooterPage;
import projectName_Utils.Utils;

public class AmazonFooter extends Utils{
	FooterPage footerPage;
	JavascriptExecutor js;
	public static Logger log= LogManager.getLogger(AmazonFooter.class.getName());
	
	@BeforeTest
	public void init() throws IOException
	{
		driver=initializeDriver();
		footerPage = new FooterPage(driver);
		js = (JavascriptExecutor) driver;
		log.info("Footer Initializations done");
	}
	
	@Test
	public void CheckBacktopTopInFooter() throws IOException
	{		
		int countOfElements = footerPage.BackToTopPresence().size();
		Assert.assertEquals(countOfElements, 1,"Back to top MISSING in Footer");
	}
	
	@Test
	public void ClickBacktopTopInFooter() throws IOException, InterruptedException
	{		
		js.executeScript("arguments[0].scrollIntoView();", footerPage.BackToTop());
		footerPage.BackToTop().click();
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{		
		driver.close();
		driver = null;
	}
	
}
