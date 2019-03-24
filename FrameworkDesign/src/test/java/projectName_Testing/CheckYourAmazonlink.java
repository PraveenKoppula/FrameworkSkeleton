package projectName_Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import projectName_Utils.Utils;

public class CheckYourAmazonlink extends Utils {

	public static Logger log= LogManager.getLogger(CheckYourAmazonlink.class.getName());
	
	@Test
	public void YourAmazonLink() throws IOException
	{
		initializeDriver();
		driver.findElement(By.xpath("//a[@id='nav-your-amazon']")).click();
		log.info("Your Amazon.com option clicked");
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
}
