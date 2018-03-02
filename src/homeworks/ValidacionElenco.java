package homeworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidacionElenco {
	static WebDriver driver;

	public static void main(String[] args) {

		SetUp("http://www.imdb.com/");

		SearchMovie("Lord of the Rings");

		ClickLink("More title matches");

		VerifyMovie("El retorno del rey","2003");

		VerifyMovieTitles("El retorno del rey","2003");

		ClickLink("See full cast");

		VerifyRoles();
		
		TearDown();
	}

	private static void SetUp(String urlToOpen) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(urlToOpen);		
	}

	private static void SearchMovie(String movieName) {
		WebElement searchInput = driver.findElement(By.id("navbar-query"));
		WebElement searchButton = driver.findElement(By.id("navbar-submit-button"));

		searchInput.clear();
		searchInput.sendKeys(movieName);
		searchButton.click();
	}

	private static void ClickLink(String linkName) {
		//WebElement linkToClick = driver.findElement(By.partialLinkText("More title matches"));
		WebElement linkToClick = driver.findElement(By.linkText(linkName));

		linkToClick.click();		
	}

	private static void VerifyMovie(String movieName, String movieYear) {
		List <WebElement> movieLists = driver.findElements(By.className("findResult"));
		WebElement correctElement = null;
		//movieLists.size();
		//elem.getText();
		//elem.getAttribute("textContent");
		
		for(WebElement elem: movieLists) {
			if(elem.getText().contains(movieName) && elem.getText().contains(movieYear)) {
				correctElement = elem;
				break;
			}
		}
		WebElement correctLink = correctElement.findElement(By.partialLinkText(movieName));
		
		correctLink.click();
	}

	private static void VerifyMovieTitles(String movieName, String movieYear) {
		
		WebElement pageTitle = driver.findElement(By.className("title_wrapper"));
		
		if(pageTitle.getText().contains(movieName) && pageTitle.getText().contains(movieYear)) {
			System.out.println("El titulo de la pelicula tiene el titulo de " + movieName + " y fue exhibida en el año " + movieYear);
		}
	}

	private static void VerifyRoles() {
		String actor = null;
		String role = null;
		//List <WebElement> actorList = driver.findElements(By.className("itemprop"));
		//List <WebElement> characterList = driver.findElements(By.className("character"));
			
		WebElement castListTable = driver.findElement(By.className("cast_list"));
		List <WebElement> totalRowCount = castListTable.findElements(By.xpath("//*[@class='cast_list']/tbody/tr"));
		//List<WebElement> totalColCount = castListTable.findElements(By.xpath("//*[@class='cast_list']/tbody/tr/td"));

		System.out.println("Amount of rows: " + totalRowCount.size());
		//System.out.println("Amount of columns: " + totalColCount.size());
		
		int rowCounter = 1;
		for(WebElement currentRow:totalRowCount)
		{
		      List <WebElement> totalColCount = currentRow.findElements(By.xpath("td"));
		      int columnCounter = 1;
		      for(WebElement currentCol:totalColCount)
		      {
		    	  if(columnCounter == 2) {
		    		  actor = currentCol.getText();
		    	  }
		    	  
		    	  if(columnCounter == 4) {
		    		  role = currentCol.getText();
		    	  }
		    	  
		    	  if(columnCounter == 4) {
		    		  System.out.println("Row: " + rowCounter + "    Actor: " + actor + "    Role: " + role);
			    	  actor = null;
			    	  role = null;
		    	  }		    	  
		    	  columnCounter = columnCounter + 1;
		       }
		      rowCounter = rowCounter + 1;
		 }	
	}
	
	private static void TearDown() {
		driver.close(); // closes the browser window which is currently in focus.
		//if there are many windows, only will close the current and the rest will remain open

		driver.quit(); //calls the driver.dispose method, which closes all the browser windows and terminates the WebDriver session.
		//If we do not use quit() at the end of program, the WebDriver session will not be closed properly and the files will not be cleared off memory.
		//This may result in memory leak errors.	
	}
}
