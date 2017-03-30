package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahim\\Downloads\\chromedriver\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();

        String baseUrl = "https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TSTT";
        
        driver.get(baseUrl);
		

        driver.quit();

	}
}
