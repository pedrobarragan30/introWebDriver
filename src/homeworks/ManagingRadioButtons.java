package homeworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ManagingRadioButtons {

	public static void main(String[] args) {
		boolean firstSelected = true;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		
		List <WebElement> sexRadios = driver.findElements(By.name("sex"));
		
		//Select first Sex Radio Button
		sexRadios.get(0).click();
		
		//Select second Sex Radio Button
		sexRadios.get(1).click();
		
		//Is the first Sex Radio Button selected?
		firstSelected = sexRadios.get(0).isSelected();
		if(firstSelected)
			sexRadios.get(1).click();
		else
			sexRadios.get(0).click();
		
		//Both of them are useful to close the browser
		//driver.close();
		//driver.quit();
	}
}