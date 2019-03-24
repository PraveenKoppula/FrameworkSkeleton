package projectName_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectName_Resources.ExtentReport;

public class Utils extends ExtentReport{

	//INVOKING LOG4J
	public static Logger log= LogManager.getLogger(Utils.class.getName());
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{		
		//PROPERTY FILE LOADING
		FileInputStream fis = new FileInputStream("C:\\Users\\Praveen Koppula\\eclipse-workspace\\FrameworkDesign\\src\\main\\java\\projectName_Resources\\Data.properties");			
		prop = new Properties();		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		log.info("Target broswer: "+ browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("web.chrome.browser", "chrome.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			log.info("Amazon site opened");
		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
		}
//		else
//		{
//			System.setProperty("web.internetexplorer.browser", "ie.exe");
//			driver = new InternetExplorerDriver();
//		}		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	public static void navigateToPaymentMethodsPage(WebDriver driver, String email, String password)
	{
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(email);
		driver.findElement(By.id("identifierNext")).click();

		WebDriverWait d = new WebDriverWait(driver, 15);
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='passwordNext']")).click();

		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='gb']/div[2]/div[3]/div[1]/div[2]/div/a")));
		driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div[1]/div[2]/div/a")).click();

		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("gb_db")));
		String Actual_email = driver.findElement(By.className("gb_bb")).getText();

		if (Actual_email.equals(email)) {
			//System.out.println("Logged in with right person " + Actual_email);
			log.info("Logged in with right person " + Actual_email);
		} else {
			//System.out.println("Logged in with in correct person " + Actual_email);
			log.info("Logged in with in correct person " + Actual_email);
		}

		// To Click Payment methods.
		driver.findElement(By.xpath("//*[text()='Payment methods']")).click();
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='iframeBody']")));
		
	}
	
	
	public static void removeCard(WebDriver driver, String cardToBeRemoved)
			throws InterruptedException {	
		
		List<WebElement> paymentMethods = driver.findElements(By.xpath("//*[@class='b3id-instrument-details b3-instrument-details']"));

		int i = 1;
		int paymentsCount = paymentMethods.size();
		//System.out.println("total payment methods - " + paymentsCount);
		log.info("total payment methods - " + paymentsCount);
		
		while (i <= paymentsCount) {
			System.out.println("inner index " + i);
			String paymentMethodText = driver
					.findElement(By
							.xpath("//*[@id=\"iframeBody\"]/div[3]/div[2]/div/div[" + i + "]/div/div[1]/div[1]/div[1]"))
					.getText();
			//System.out.println("Paybalance/card number: " + paymentMethodText);
			log.info("Paybalance/card number: " + paymentMethodText);
			if (paymentMethodText.equals(cardToBeRemoved)) {
				//System.out.println("card found");
				log.info("card found.... yay !!!!!");
				Thread.sleep(3000);
				driver.findElement(
						By.xpath("//*[@id=\"iframeBody\"]/div[3]/div[2]/div/div["+i+"]/div/div[2]/div/div[1]"))
						.click();
				Thread.sleep(3000);
				//FAILING - need to check
				//driver.findElement(By.xpath("//*[@id=\"iframeBody\"]/div[3]/div[4]/div[2]/div[2]")).click(); /// To cancel
				
				//*[@id="iframeBody"]/div[3]/div[4]/div[2]/div[2]/div"   ----> To cancel
				//*[@id="iframeBody"]/div[3]/div[4]/div[2]/div[1]/div    --->To remove
				
				break;
			} else {
				//System.out.println("card not found");
				log.info("card not found");
			}
			i++;
		}
	}
	
}

