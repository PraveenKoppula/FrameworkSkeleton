package projectName_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

	public WebDriver driver;

	public FooterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
//	WebElement amazonLogo;

	By backToTop = By.cssSelector("span[class='navFooterBackToTopText']");
	
//	@FindBy(css="a[href*='sign_in']")
//	WebElement Login;
	
//	public WebElement login()
//	{
//		return Login;
//	}
	
	public List<WebElement> BackToTopPresence()
	{
		return driver.findElements(backToTop);
	}
	
	public WebElement BackToTop()
	{
		return driver.findElement(backToTop);
	}
	
}
