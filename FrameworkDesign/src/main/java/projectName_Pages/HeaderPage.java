package projectName_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

	public WebDriver driver;

	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//////////////////LOCATORS/////////////////////////
	By amazonLogo = By.xpath("//span[@class='nav-sprite nav-logo-base']");
	
	@FindBy(id="searchDropdownBox")
	WebElement searchDropdownBox;

	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(css="input.nav-input")
	WebElement searchButton;
	
	@FindBy(id="pagnNextString")
	WebElement nextPageButton;
	
	
	@FindBy(id="low-price")
	WebElement minPrice;
	
	@FindBy(id="high-price")
	WebElement maxPrice;

	@FindBy(xpath="//input[@aria-labelledby='a-autoid-1-announce']")
	WebElement priceGoButton;
	
	@FindBy(xpath="//ul[@id='s-results-list-atf']//li")
	List<WebElement> resultsList;
	
	
	//////////////////WRAPPERS/////////////////////////
	public List<WebElement> AmazonLogoPresense()
	{
		return driver.findElements(amazonLogo);
	}
	
	public WebElement AmazonLogo()
	{
		return driver.findElement(amazonLogo);
	}
	
	public WebElement SearchDropdownBox()
	{
		return searchDropdownBox;
	}
	
	public WebElement SearchBox()
	{
		return searchBox;
	}
	
	public WebElement SearchButton()
	{
		return searchButton;
	}

	public WebElement NextPageButton()
	{
		return nextPageButton;
	}
	
	public WebElement MinimumPrice()
	{
		return minPrice;
	}
	
	public WebElement MaximumPrice()
	{
		return maxPrice;
	}
	
	public WebElement PriceGoButton()
	{
		return priceGoButton;
	}

	public List<WebElement> ResultsList()
	{
		return resultsList;
	}
	
}
