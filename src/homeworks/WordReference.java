package homeworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WordReference {
	
	static WebDriver driver;

	public static void main(String[] args) {
		SetUp("http://www.wordreference.com/");
		
		Search("Almond");
		
		WRreverse();
		
		SeeAlso(3);
		
		SearchInternal("Rice");
		
		WRreverse();
		
		SeeAlso(5);
		
		TearDown();
	}

	private static void SetUp(String urlToOpen) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(urlToOpen);		
	}
	
	private static void WRreverse() {
		WebElement tab = driver.findElement(By.partialLinkText("WR Reverse"));
		
		tab.click();
	}

	private static void SeeAlso(int numberOfElementToSearch) {
		WebElement linksTable = driver.findElement(By.id("link"));
		List <WebElement> totalTerms = linksTable.findElements(By.xpath("//*[@id='link']/ul/li"));
		
		//System.out.println(totalTerms.size());
		
		int elementCounter = 1;
		for(WebElement item:totalTerms) {
			if(elementCounter == numberOfElementToSearch) {
				driver.findElement(By.linkText(item.getText())).click();
				break;				
			}
			elementCounter++;
		}
	}

	private static void Search(String searchTerm) {
		WebElement searchField = driver.findElement(By.className("ac-input"));
		WebElement submitButton = driver.findElement(By.className("submit-button"));
		
		searchField.clear();
		searchField.sendKeys(searchTerm);
		submitButton.click();		
	}
	
	private static void SearchInternal(String searchTerm) {
		WebElement searchField = driver.findElement(By.id("si"));
		WebElement submitButton = driver.findElement(By.id("searchBtn"));
		
		searchField.clear();
		searchField.sendKeys(searchTerm);
		submitButton.click();		
	}
	
	private static void TearDown() {
		driver.close(); // closes the browser window which is currently in focus.
		//if there are many windows, only will close the current and the rest will remain open

		driver.quit(); //calls the driver.dispose method, which closes all the browser windows and terminates the WebDriver session.
		//If we do not use quit() at the end of program, the WebDriver session will not be closed properly and the files will not be cleared off memory.
		//This may result in memory leak errors.	
	}
}
