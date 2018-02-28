package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ManagingSelects2 {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		
		//Working with the Select for Continents		
		WebElement Continent = driver.findElement(By.name("continents"));		
		Select getContinent = new Select(Continent);		
		getContinent.selectByVisibleText("Australia");
		
		//Working with the Select for Selenium Commands
		WebElement seleniumCommands = driver.findElement(By.id("selenium_commands"));		
		Select scSelect = new Select(seleniumCommands);		
		scSelect.selectByVisibleText("Browser Commands");
		scSelect.selectByIndex(2);
		scSelect.selectByVisibleText("WebElement Commands");
		scSelect.deselectByVisibleText("Switch Commands");
		
		scSelect.deselectAll();
	}
}