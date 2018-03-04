package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.*;



public class Multibrowser {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		Setup("http://www.imdb.com","chrome");
		Setup("http://www.imdb.com","firefox");
		Setup("http://www.imdb.com","edge");
		Setup("http://www.imdb.com","IE");
		Setup("http://www.imdb.com","safari");
	}
	
	private static void Setup(String urlToOpen, String browserToUse) {
		switch(browserToUse) {
		case "chrome":
			System.out.println("Arranca el browser " + browserToUse + " porfa y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("-disable-notifications");
			//options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);
		   break;
		case "firefox":
			System.out.println("Arranca el browser " + browserToUse + " porfa y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.gecko.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.out.println("Arranca el browser " + browserToUse + " porfa y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.edge.driver, "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver = new EdgeDriver();
			break;
		//case "IE":
		//	System.out.println("Arranca el browser " + browserToUse + " porfa y navega a la pagina: " + urlToOpen);
			//System.setProperty("webdriver.ie.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
		//	
		//	driver = new InternetExplorerDriver();
		//	break;
		default:
			System.out.println("The Browser " + browserToUse + " is NOT supported");
		}
		
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
