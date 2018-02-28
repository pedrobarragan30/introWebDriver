package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ManagingSelects {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		
		WebElement birthYear = driver.findElement(By.name("birthday_year"));
		WebElement birthMonth = driver.findElement(By.name("birthday_month"));
		WebElement birthDay = driver.findElement(By.name("birthday_day"));
		
		Select daySelector = new Select(birthDay);
		Select monthSelector = new Select(birthMonth); 
		Select yearSelector = new Select(birthYear);
		
		daySelector.selectByValue("3");
		monthSelector.selectByIndex(3);
		yearSelector.selectByVisibleText("1988");
		
		//Maximize the Window
		driver.manage().window().maximize();
		
		//daySelector.deselectByIndex(3);
		//monthSelector.deselectByVisibleText("mar");
		//yearSelector.deselectByValue("1988");
		
		//WebElement Sex = driver.findElement(By.name("sex"));
		
		String str = driver.findElement(By.name("sex")).getAttribute("checked");
		if (str.equalsIgnoreCase("true"))
		{
		    System.out.println("Checkbox selected");
		}		
	}
}
