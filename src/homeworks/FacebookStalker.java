package homeworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookStalker {
	static WebDriver driver;
	
	public static void main(String[] args) {

		SetUp("https://www.facebook.com/");

		Login();

		FriendSearchandOpen("La Tina Jabones Velas y Accesorios");

		OpenPhotos();

		SelectAlbum(1);

		LikePhotos();
	}

	private static void SetUp(String urlToOpen) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(urlToOpen);
	}

	private static void Login() {
		String user = "pbaro30@hotmail.com";
		String pswd = "HIPh17h0044a!";
		
		WebElement userField = driver.findElement(By.id("email"));
		WebElement pswdField = driver.findElement(By.id("pass"));
		
		userField.clear();
		userField.sendKeys(user);
		
		pswdField.clear();
		pswdField.sendKeys(pswd);
		
		WebElement Login = driver.findElement(By.id("loginbutton"));
		Login.submit();
	}

	private static void FriendSearchandOpen(String searchTerm) {
		WebElement searchField = driver.findElement(By.className("_1frb"));
		
		searchField.clear();
		searchField.sendKeys(searchTerm);
		
		WebElement searchButton = driver.findElement(By.tagName("button"));
		searchButton.submit();
		
		//1st Version
		driver.findElement(By.partialLinkText(searchTerm)).click();	
		
		//2nd Version
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement friendPage = driver.findElement(By.partialLinkText(searchTerm));	
		//wait.until(ExpectedConditions.elementToBeClickable(friendPage));
		//friendPage.click();
		
		//3rd Version
		//WebDriverWait wait = new WebDriverWait(driver, 10); 
		//WebElement friendPage = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(searchTerm)));
		//friendPage.click();
		
	}

	private static void OpenPhotos()  {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//1st Version
		WebElement album = driver.findElement(By.linkText("Fotos"));
		album.click();
		
		WebElement verTodos = driver.findElement(By.linkText("Ver todos"));
		verTodos.click();
		
		
		//2nd Version
		//WebElement album = driver.findElement(By.linkText("Fotos"));
		//wait.until(ExpectedConditions.elementToBeClickable(album));
		//album.click();
		
		//WebElement verTodos = driver.findElement(By.linkText("Ver todos"));
		//wait.until(ExpectedConditions.elementToBeClickable(verTodos));
		//verTodos.click();		
	}

	private static void SelectAlbum(Integer albumNumber) {
		List <WebElement> albumList = driver.findElements(By.xpath("//*[@class='_3rte']/a"));
		
		Integer counter = 1;
		WebElement correctAlbum = null;

		for(WebElement currentAlbum: albumList) {
			if(counter == (albumNumber * 2)) {
				correctAlbum = currentAlbum;
				break;
				}
			counter++;
			}		
		correctAlbum.click();
	}

	private static void LikePhotos() {
		List <WebElement> picturesList1 = driver.findElements(By.partialLinkText("Me Gusta"));
		List <WebElement> picturesList = driver.findElements(By.linkText("Me Gusta"));
		List <WebElement> totalCount = driver.findElements(By.xpath("//*[@class='_4crj']/a"));
	}
}
