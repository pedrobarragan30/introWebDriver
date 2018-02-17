package homeworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		
		driver.findElement(By.partialLinkText(searchTerm)).click();		
		//driver.findElement(By.linkText(searchTerm)).click();
		
		//WebElement link1 = driver.findElement(By.partialLinkText(searchTerm));		
		//WebElement link2 = driver.findElement(By.linkText(searchTerm));
		
		//link1.click();
		//link2.click();
		
		
	}

	private static void OpenPhotos()  {
		WebElement Album = driver.findElement(By.linkText("Fotos"));

		Album.click();
		
		WebElement verTodos = driver.findElement(By.linkText("Ver todos"));
		
		verTodos.click();
		
	}

	private static void SelectAlbum(Integer albumNumber) {
//		List <WebElement> albumsList = driver.findElements(By.className("_3rte"));
//		
//		Integer counter = 1;
//		WebElement correctAlbum = null;
//		
//		for(WebElement currentAlbum: albumsList) {
//			if(counter == albumNumber) {
//				correctAlbum = currentAlbum;
//				break;
//			}
//			counter++;
//		}
//		
//		String albumName = correctAlbum.getText();
		
		
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
		List <WebElement> totalColCount = driver.findElements(By.xpath("//*[@class='_4crj']/a"));
		//Integer counter = 1;
		WebElement correctAlbum = null;

//		for(WebElement currentAlbum: albumList) {
//			if(counter == (albumNumber * 2)) {
//				correctAlbum = currentAlbum;
//				break;
//				}
//			counter++;
//			System.out.println("");
//			}		
//		correctAlbum.click();
		
	}
}
