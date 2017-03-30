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


public class MainPage {
	
	@BeforeClass
	public static void beforClassSetUp() throws Exception 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahim\\Downloads\\chromedriver\\chromedriver.exe");
		}

//Create new instance of webdriver
	WebDriver driver = new ChromeDriver();

// Set URL and navigate to page before each test
	@Before
	public void setUp()
	{
		String baseUrl = "https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TSTT";
		driver.get(baseUrl);
	}
	
// Close driver after each test
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
		
//	Test to verify title displayed is correct
	@Test
	public void  checkTitle()
	{
		String expectedTitle = "Energy - Compare Gas and Electricity Suppliers | Compare The Market";
		String actualTitle = driver.getTitle();		
		Assert.assertEquals(actualTitle, expectedTitle);		
	}

//	Test to verify postcode field is visible
	@Test
	public void checkPostCodeField()
		{
		boolean status = driver.findElement(By.id("your-postcode")).isDisplayed();
		}
	
//	Test to verify bill handy field is visible
	@Test
	public void checkBillHandyField()
	{		
		boolean staus1 = driver.findElement(By.id("have-bill")).isDisplayed();
		boolean staus2 = driver.findElement(By.id("no-bill-label")).isDisplayed();
	}
	
//	Test to verify what do you want to compare field is visible
	@Test
	public void checkCompareWhatField()
	{
		boolean staus1 = driver.findElement(By.id("compare-both-label")).isDisplayed();
		boolean staus2 = driver.findElement(By.id("compare-electricity-label")).isDisplayed();
		boolean status3 = driver.findElement(By.id("compare-gas-label")).isDisplayed();
	}
	
//	Test to verify is gas and electricity from same supplier field is visible
	@Test
	public void checkIsSameSupplierField()
	{	
		boolean staus1 = driver.findElement(By.id("same-supplier-yes")).isDisplayed();
		boolean staus2 = driver.findElement(By.id("same-supplier-no")).isDisplayed();
	}
	
//	Test to verify who supplies your energy field is visible
	@Test
	public void checkWhoSuppliesYourEnergyFields()
	{
		driver.findElement(By.id("your-postcode")).sendKeys("PE2 6YS");
		driver.findElement(By.id("find-postcode")).click();
		
		boolean staus1 = driver.findElement(By.id("dual-top-six-british-gas")).isDisplayed();
		boolean staus2 = driver.findElement(By.id("dual-top-six-edf")).isDisplayed();
		boolean statu3 = driver.findElement(By.id("dual-top-six-eon")).isDisplayed();
		boolean staus4 = driver.findElement(By.id("dual-top-six-npower")).isDisplayed();
		boolean staus5 = driver.findElement(By.id("dual-top-six-scottish-power")).isDisplayed();
		boolean statu6 = driver.findElement(By.id("dual-top-six-sse")).isDisplayed();
	}
//	Test to verify other supplier field is visible
	@Test
	public void checkOtherSupplier()
	{
		driver.findElement(By.id("your-postcode")).sendKeys("PE2 6YS");
		driver.findElement(By.id("find-postcode")).click();
		
		boolean status = driver.findElement(By.id("sel")).isDisplayed();
	}
	
//	Test to verify next button is visible
	@Test
	public void checkNextButton()
	{
		driver.findElement(By.id("your-postcode")).sendKeys("PE2 6YS");
		driver.findElement(By.id("find-postcode")).click();
		
		boolean status = driver.findElement(By.id("goto-your-supplier-details")).isDisplayed();
	}
}
