package projectName_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokingBrowser {

	//INVOKING LOG4J
	public static Logger log= LogManager.getLogger(InvokingBrowser.class.getName());
	
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
	
}

