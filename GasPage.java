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

public class GasPage {

//	Set property for driver
	@BeforeClass
	public static void beforClassSetUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahim\\Downloads\\chromedriver\\chromedriver.exe");
	}

//	New chromdriver
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
		driver.findElement(By.id("electricity-usage")).sendKeys("5000");
		Thread.sleep(5000);
		driver.findElement(By.id("goto-your-energy")).click();
		Thread.sleep(5000);
	}

//	Close web page after each test
	@After
	public void refresh()
	{
		driver.close();
	}

//	Quit driver once all tests have run
	@AfterClass
	public static void clossAll()
	{
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}

//	Verify correct title is displayed
	@Test
	public void  checkTitle()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Energy - Compare Gas and Electricity Suppliers | Compare The Market");
	}

//	Verify gas tariff field is displayed
	@Test
	public void checkGasTariff()
		{
		boolean status = driver.findElement(By.id("gas-tariff-additional-info")).isDisplayed();
		}

//	Verify payment method field is displayed
	@Test
	public void checkGasPaymentMethodField()
	{
		boolean status = driver.findElement(By.id("gas-payment-method-dropdown-link")).isDisplayed();
	}

//	Verify gas is main source field is displayed
	@Test
	public void checkGasMainSourceField()
	{
		boolean status1 = driver.findElement(By.id("gas-main-heating-yes")).isDisplayed();
		boolean status2 = driver.findElement(By.id("gas-main-heating-no")).isDisplayed();
	}

//	Verify current usage field is displayed
	@Test
	public void checkWhatIsYourCurrentUsageFields()
	{

		boolean status1 = driver.findElement(By.id("kwhSpendG")).isDisplayed();
		boolean status2 = driver.findElement(By.id("poundSpendG")).isDisplayed();
		boolean status3 = driver.findElement(By.id("gas-usage")).isDisplayed();
		boolean status4 = driver.findElement(By.id("type-of-Gas-bill-usage-dropdown")).isDisplayed();
	}

//	Verify back button is displayed
	@Test
	public void checkBackButton()
	{
		boolean status = driver.findElement(By.id("go-back")).isDisplayed();
	}

//	Verify next button is displayed
	@Test
	public void checkNextButton()
	{
			boolean status = driver.findElement(By.id("goto-your-energy")).isDisplayed();
	}
}

@Test
public void new(){

		}
