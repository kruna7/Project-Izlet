package page.objects;

import org.openqa.selenium.*;

public class HomePage {

	// staticke promenjive koje koristimo na pocetnoj stani
	public static final String URL = "http://localhost/izlet/";

	// vecina se odnosi na xpath, odnosno na poziciju odredjenih polja na sajtu
	public static final String USERNAME_LOGIN = "//input[@placeholder='username']";
	public static final String PASSWORD_LOGIN = "//input[@placeholder='password']";
	public static final String LOGIN_BUTTON = "//input[@value='Log in']";

	public static final String FIRST_NAME = "//input[@name='firstname']";
	public static final String LAST_NAME = "//input[@name='lastname']";
	public static final String USERNAME = "//form[@action='processregister.php']//input[@name='username']";
	public static final String EMAIL = "//input[@name='email']";
	public static final String PASSWORD = "//form[@action='processregister.php']//input[@name='password']";
	public static final String REGISTER_BUTTON = "//input[@id='blue_btn']";

	// metoda koja otvara pocetnu stranu
	public static void openHomePage(WebDriver driver) {
		driver.get(URL);
	}

	// metoda koja nam omogucava da se u svakom trenutku vratimo na pocetnu stranu
	public static void goToHomePage(WebDriver driver) {
		driver.navigate().to(URL);
	}

	// Username login
	// metoda koja nalazi gde se nalazi element preko xpath-a
	public static WebElement getUsernameLogin(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(USERNAME_LOGIN));
		return wb;
	}

	// a zatim klikce na taj element
	public static void clickUsernameLogin(WebDriver driver) {
		getUsernameLogin(driver).click();
	}

	// nakon cega salje podatke koji se ispisuju
	public static void sendKeysUsernameLogin(WebDriver driver, String tekst) {
		getUsernameLogin(driver).sendKeys(tekst);

	}

	// Password login, ista metodologija kao za username
	public static WebElement getPasswordLogin(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(PASSWORD_LOGIN));
		return wb;
	}

	public static void clickPasswordLogin(WebDriver driver) {
		getPasswordLogin(driver).click();
	}

	public static void sendKeysPasswordLogin(WebDriver driver, String tekst) {
		getPasswordLogin(driver).sendKeys(tekst);

	}

	// Login button (posto je dugme u pitanju, ne saljemo tekst, osim toga, isti
	// metodi kao za username)
	public static WebElement getLogin(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(LOGIN_BUTTON));
		return wb;
	}

	public static void clickLogin(WebDriver driver) {
		getLogin(driver).click();
	}

	// First name
	public static WebElement getFirstName(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(FIRST_NAME));
		return wb;
	}

	public static void clickFirstName(WebDriver driver) {
		getFirstName(driver).click();
	}

	public static void sendKeysFirstName(WebDriver driver, String tekst) {
		getFirstName(driver).sendKeys(tekst);

	}

	// Last name
	public static WebElement getLastName(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(LAST_NAME));
		return wb;
	}

	public static void clickLastName(WebDriver driver) {
		getLastName(driver).click();
	}

	public static void sendKeysLastName(WebDriver driver, String tekst) {
		getLastName(driver).sendKeys(tekst);

	}

	// Username
	public static WebElement getUsername(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(USERNAME));
		return wb;
	}

	public static void clickUsername(WebDriver driver) {
		getUsername(driver).click();
	}

	public static void sendKeysUsername(WebDriver driver, String tekst) {
		getUsername(driver).sendKeys(tekst);

	}

	// Email
	public static WebElement getEmail(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(EMAIL));
		return wb;
	}

	public static void clickEmail(WebDriver driver) {
		getEmail(driver).click();
	}

	public static void sendKeysEmail(WebDriver driver, String tekst) {
		getEmail(driver).sendKeys(tekst);

	}

	// Password
	public static WebElement getPassword(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(PASSWORD));
		return wb;
	}

	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	public static void sendKeysPassword(WebDriver driver, String tekst) {
		getPassword(driver).sendKeys(tekst);

	}

	// Register button
	public static WebElement getSubmit(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(REGISTER_BUTTON));
		return wb;
	}

	public static void clickSubmit(WebDriver driver) {
		getSubmit(driver).click();
	}

}
