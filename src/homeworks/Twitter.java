package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Twitter {
	
	static WebDriver driver;

	public static void main(String[] args) {
		SetUp("https://twitter.com/login?lang=en");
		
		Login();
		
		Tweet();
		
		SearchFriend();
		
		LikeTweet();
		
		ReTweet();	
	}

	private static void SetUp(String urlToOpen) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(urlToOpen);	
		
	}

	private static void Login() {
		String user = "test";
		String pswd = "test";
		
		WebElement userField = driver.findElement(By.name("session[username_or_email]"));
		WebElement pswdField = driver.findElement(By.name("session[password]"));
		WebElement rememberMe = driver.findElement(By.name("remember_me"));
		
		userField.clear();
		pswdField.clear();
		rememberMe.clear();
		
		userField.sendKeys(user);
		pswdField.sendKeys(pswd);
		
	}

	private static void Tweet() {
		// TODO Auto-generated method stub
		
	}

	private static void SearchFriend() {
		// TODO Auto-generated method stub
		
	}

	private static void LikeTweet() {
		// TODO Auto-generated method stub
		
	}

	private static void ReTweet() {
		// TODO Auto-generated method stub
		
	}
}
