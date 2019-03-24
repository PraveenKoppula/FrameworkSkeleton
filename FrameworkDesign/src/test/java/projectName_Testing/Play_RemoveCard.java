package projectName_Testing;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectName_Pages.FooterPage;
import projectName_Utils.Utils;

public class Play_RemoveCard extends Utils {

	Logger log= LogManager.getLogger(Play_RemoveCard.class.getName());
	
	@BeforeTest
	public void init() throws IOException
	{
		driver=initializeDriver();
		log.info("Play_RemoveCard Initializations done");
		driver.get("https://pay.google.com");
	}
	
	@Test
	public void CheckAndRemoveCard() throws InterruptedException {	
		String email = "gamyam84001@gmail.com";
		String password = "test1233";
		String cardToBeRemoved = "Visa •••• 3110";

		navigateToPaymentMethodsPage(driver, email, password);
		driver.switchTo().frame("standalone-container-main-widgetIframe");		
		removeCard(driver, cardToBeRemoved);
		
		driver.close();
	}
		
}

