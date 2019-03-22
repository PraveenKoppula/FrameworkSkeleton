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
import projectName_Utils.InvokingBrowser;

public class Scenario1 extends InvokingBrowser{
	FooterPage footerPage;
	JavascriptExecutor js;
	public static Logger log= LogManager.getLogger(Scenario1.class.getName());
	
	@BeforeTest
	public void init() throws IOException
	{
		driver=initializeDriver();
		js = (JavascriptExecutor) driver;
		log.info("Framework - test scenario1 - initialization");
	}
	
	@Test
	public void step1() throws IOException
	{		
		
		log.info("Framework - test scenario1 - step1");
		System.out.println("Framework - test scenario1 - step1");
		//Assert.assertEquals(actual, expected,"required msg when failed");
	}
	
	@Test
	public void step2() throws IOException, InterruptedException
	{	
		log.info("Framework - test scenario1 - step2");
		System.out.println("Framework - test scenario1 - step2");
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{		
		driver.close();
		driver = null;
	}
	
}
