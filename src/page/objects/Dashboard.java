package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dashboard {

	// strana na kojoj smo nakon sto se ulogujemo
	public static final String DASHBOARD_URL = "http://localhost/izlet/dashboard.php";

	// sledece promenjive sadrze xpath u sebi:
	public static final String MAKE_POST = "//a[contains(text(),'Make a post')]";
	public static final String TITLE = "//input[@placeholder='Naziv']";
	public static final String LOCATION = "//input[@placeholder='Lokacija']";
	public static final String TRANSPORT = "//select[@name='transport']";
	public static final String DESCRIPTION = "//textarea[@placeholder='Opis']";
	public static final String POST = "//input[@value='Post']";
	// ostale sadrze imena klasa kojima pripadaju
	public static final String DOTDOTDOT = "fa-ellipsis-v";
	public static final String EDIT = "fa-edit";
	public static final String TRASH = "fa-trash-alt";
	// staticke promenjive koje koristimo za izmenu posta
	public static final String CHANGE_TITLE = "//input[@id='title']";
	public static final String CHANGE_LOCATION = "//input[@id='location']";
	public static final String CHANGE_TRANSPORT = "//select[@id='transport']";
	public static final String CHANGE_DESCRIPTION = "//textarea[@id='description']";
	
	public static final String CONFIRM_CHANGE = "//div[@class='popupEdit']//input[@value='Post']";
	public static final String CANCEL_CHANGE = "//div[@id='close3']//i[@class='fas fa-times']";

	// navigacija na "Dashboard" stranu, radi samo ako smo ulogovani
	public static void goToDashboard(WebDriver driver) {
		driver.navigate().to(DASHBOARD_URL);
	}

	// metoda za otvaranje prozora za dodavanje objave
	public static void makeAPost(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(MAKE_POST));
		wb.click();
	}

	// post title - prvo lociramo polje gde se upisuje naslov
	public static WebElement getTitle(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(TITLE));
		return wb;
	}

	// zatim kliknemo na polje
	public static void clickTitle(WebDriver driver) {
		getTitle(driver).click();
	}

	// i onda posaljemo tekst
	public static void sendKeysTitle(WebDriver driver, String tekst) {
		getTitle(driver).sendKeys(tekst);

	}

	// post location, isti princip kao i za post title
	public static WebElement getLocation(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(LOCATION));
		return wb;
	}

	public static void clickLocation(WebDriver driver) {
		getLocation(driver).click();
	}

	public static void sendKeysLocation(WebDriver driver, String tekst) {
		getLocation(driver).sendKeys(tekst);

	}

	// post select transport
	public static WebElement getSelect(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(TRANSPORT));
		return wb;
	}

	public static void selectTransport(WebDriver driver, String transport) {
		Select sel = new Select(getSelect(driver));
		sel.selectByVisibleText(transport);
	}

	// post description
	public static WebElement getDescription(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(DESCRIPTION));
		return wb;
	}

	public static void clickDescription(WebDriver driver) {
		getDescription(driver).click();
	}

	public static void sendKeysDescription(WebDriver driver, String tekst) {
		getDescription(driver).sendKeys(tekst);

	}

	// post a post :)
	public static WebElement sendPost(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(POST));
		return wb;
	}

	public static void clickPost(WebDriver driver) {
		sendPost(driver).click();
	}

	// metoda koja klikce na ... (dotdotdot) meni
	// pronalazimo element preko imena klase
	public static void dotdotdot(WebDriver driver) {
		List<WebElement> choseOptions = driver.findElements(By.className(DOTDOTDOT));
		choseOptions.get(0).click();
	}
	
	//metoda koja izracunava duzinu liste - koliko objava ima korisnik
	public static int myPost(WebDriver driver) {
		List<WebElement> myPost = driver.findElements(By.className(DOTDOTDOT));
		int duzListe= myPost.size();
		return duzListe;
		}

	// metoda koja brise prvu objavu
	public static void clickDeletePost(WebDriver driver) {
		dotdotdot(driver);
		List<WebElement> clickDeletePost = driver.findElements(By.className(TRASH));
		clickDeletePost.get(0).click();
	}

	// metoda koja vrsi izmene na poslednjoj izmeni
	public static void clickEditPost(WebDriver driver) {
		dotdotdot(driver);
		List<WebElement> clickEditPost = driver.findElements(By.className(EDIT));
		System.out.println(clickEditPost);
		clickEditPost.get(0).click();
	}

	// title / pop-up za edit, brisanje svega i i slanje novog teksta
	public static WebElement getChangeTitle(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(CHANGE_TITLE));
		return wb;
	}

	public static void clickChangeTitle(WebDriver driver) {
		getChangeTitle(driver).click();
	}

	public static void sendKeysCtrlATitle(WebDriver driver) {
		getChangeTitle(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		getChangeTitle(driver).sendKeys(Keys.DELETE);
	}

	public static void sendKeysChangeTitle(WebDriver driver, String tekst) {
		getChangeTitle(driver).sendKeys(tekst);
	}

	// location / pop-up za edit, brisanje svega i i slanje novog teksta
	public static WebElement getChangeLocation(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(CHANGE_LOCATION));
		return wb;
	}

	public static void clickChangeLocation(WebDriver driver) {
		getChangeLocation(driver).click();
	}

	public static void sendKeysCtrlALocation(WebDriver driver) {
		getChangeLocation(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		getChangeLocation(driver).sendKeys(Keys.DELETE);
	}

	public static void sendKeysChangeLocation(WebDriver driver, String tekst) {
		getChangeLocation(driver).sendKeys(tekst);
	}

	// Description / pop-up za edit, brisanje svega i i slanje novog teksta
	public static WebElement getChangeDescription(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(CHANGE_DESCRIPTION));
		return wb;
	}

	public static void clickChangeDescription(WebDriver driver) {
		getChangeDescription(driver).click();
	}
	
	public static void sendKeysCtrlADescription(WebDriver driver) {
		getChangeDescription(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		getChangeDescription(driver).sendKeys(Keys.DELETE);}


	public static void sendKeysChangeDescription(WebDriver driver, String tekst) {
		getChangeDescription(driver).sendKeys(tekst);
	}

	// transport / pop-up za edit, bira drugi vid transporta
		public static WebElement getChangeTransport(WebDriver driver) {
			WebElement wb = driver.findElement(By.xpath(CHANGE_TRANSPORT));
			return wb;
		}

		public static void selectChangeTransport(WebDriver driver, String transport) {
			Select sel = new Select(getChangeTransport(driver));
			sel.selectByVisibleText(transport);
		}
		
		// confirm / pop-up za edit, metode koje potvrdjuju promenu
		public static WebElement getConfirmChange(WebDriver driver) {
			WebElement wb = driver.findElement(By.xpath(CONFIRM_CHANGE));
			return wb;
		}

		public static void clickConfirmChange(WebDriver driver) {
			getConfirmChange(driver).click();
		}
		
		//cancel / pop-up za edit, metode koje otkazuju promenu
		public static WebElement getCancelChange(WebDriver driver) {
			WebElement wb = driver.findElement(By.xpath(CONFIRM_CHANGE));
			return wb;
		}

		public static void clickCancelChange(WebDriver driver) {
			getCancelChange(driver).click();
		}
}
