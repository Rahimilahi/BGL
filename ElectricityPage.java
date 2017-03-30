package Test1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ElectricityPage {
	
//	Set system property for WebDriver
	@BeforeClass
	public static void beforClassSetUp() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahim\\Downloads\\chromedriver\\chromedriver.exe");
	}
	
//Create new instance of webdriver
	WebDriver driver = new ChromeDriver();

//	Navigate to correct page before each test
	@Before
	public void setUp() throws InterruptedException
	{
		String baseUrl = "https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TSTT";
		driver.get(baseUrl);
		
		
		driver.findElement(By.id("your-postcode")).sendKeys("PE2 6YS");
		driver.findElement(By.id("find-postcode")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("goto-your-supplier-details")).click();
		Thread.sleep(5000);
	}

//	Close driver after each test
	@After
	public void refresh()
	{
		driver.close();
	}
	
//	Quit driver at end of all tests
	@AfterClass
	public static void clossAll()
	{
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
		
//	Verify Title is correct
	@Test
	public void  checkTitle()
	{
		String actualTitle = driver.getTitle();		
		Assert.assertEquals(actualTitle, "Energy - Compare Gas and Electricity Suppliers | Compare The Market");
	}

//	Test to verify electricity tariff field is displayed
	@Test
	public void checkEclectricityTariff()
	{
		boolean status = driver.findElement(By.id("electricity-tariff-additional-info")).isDisplayed();
	}
	
//	Test to verify economy 7 field is displayed
	@Test
	public void checkEconomy7Field()
	{
		boolean status1 = driver.findElement(By.name("economy-7-yes")).isDisplayed();
		boolean status2 = driver.findElement(By.name("economy-7-no")).isDisplayed();
	}

//	Test to verify electricity Payment method field is displayed
	@Test
	public void checkElectricityPaymentMethodField()
	{
		boolean status1 = driver.findElement(By.id("electricity-payment-method-dropdown-link")).isDisplayed();
	}

//	Test to verify is electricity main source field is displayed
	@Test
	public void checkIsElectricityMainSourceField()
	{
		boolean status1 = driver.findElement(By.id("electricity-main-heating-yes")).isDisplayed();
		boolean status2 = driver.findElement(By.id("electricity-main-heating-no")).isDisplayed();
	}
	
//	Test to verify current usage field is displayed
	@Test
	public void checkWhatIsYourCurrentUsageFields()
	{
		boolean status1 = driver.findElement(By.id("kwhSpend")).isDisplayed();
		boolean status2 = driver.findElement(By.id("poundSpend")).isDisplayed();
		boolean status3 = driver.findElement(By.id("electricity-usage")).isDisplayed();
		boolean status4 = driver.findElement(By.id("electricity-usage-dropdown")).isDisplayed();
	}

//	Test to verify back button displayed
	@Test
	public void checkBackButton()
	{
		boolean status = driver.findElement(By.id("go-back")).isDisplayed();		
	}
	
//	Test to verify next button is displayed
	@Test
	public void checkNextButton()
	{
		boolean status = driver.findElement(By.id("goto-your-energy")).isDisplayed();
	}
}


