package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Multibrowser {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		Setup("http://www.imdb.com","chrome");
	}
	
	private static void Setup(String urlToOpen, String browserToUse) {
		switch(browserToUse) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);
		   break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver =  new FirefoxDriver();
			break;		
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(urlToOpen);
	}
}
