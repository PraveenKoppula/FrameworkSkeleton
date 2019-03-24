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

public class Scenario2 extends Utils{
	FooterPage footerPage;
	JavascriptExecutor js;
	public static Logger log= LogManager.getLogger(Scenario2.class.getName());
	
	@BeforeTest
	public void init() throws IOException
	{
		driver=initializeDriver();
		js = (JavascriptExecutor) driver;
		log.info("Framework - test scenario2 - initialization");
	}
	
	@Test
	public void step1() throws IOException
	{		
		
		log.info("Framework - test scenario2 - step1");
		System.out.println("Framework - test scenario2 - step1");
		//Assert.assertEquals(5, 1,"Back to top MISSING in Footer");
	}
	
	@Test
	public void step2() throws IOException, InterruptedException
	{	
		log.info("Framework - test scenario2 - step2");
		System.out.println("Framework - test scenario2 - step2");
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{		
		driver.close();
		driver = null;
	}
	
}
