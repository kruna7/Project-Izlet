package page.tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import utility.Constant;
import utility.ExcelUtils;

public class HomePageTest {

	// metoda koja dozvoljava korisniku da preko konzole unese podatke za login
	public static void fillLoginScanner(WebDriver driver) throws Exception {
		Scanner sc = new Scanner(System.in);
		String u, p;

		System.out.println("Unesite USERNAME:");
		u = sc.nextLine();
		System.out.println("Unesite PASSWORD:");
		p = sc.nextLine();

		HomePage.clickUsernameLogin(driver);
		HomePage.sendKeysUsernameLogin(driver, u);
		HomePage.clickPasswordLogin(driver);
		HomePage.sendKeysPasswordLogin(driver, p);

		HomePage.clickLogin(driver);
		sc.close();
	}

	// metoda koja popunjava login formu za jednog korisnika iz tabele
	public static void fillLoginForm(WebDriver driver, int i) throws Exception {
		String text;
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE, Constant.SHEET_NAME);

		HomePage.clickUsernameLogin(driver);
		text = ExcelUtils.getCellData(i, 2);
		HomePage.sendKeysUsernameLogin(driver, text);

		HomePage.clickPasswordLogin(driver);
		text = ExcelUtils.getCellData(i, 4);
		HomePage.sendKeysPasswordLogin(driver, text);

		HomePage.clickLogin(driver);
	}

	// metoda koja testira login za sve korisnike iz tabele (WithAllData)
	// pokusava unos podataka iz tabele, ako je uspesan login, obavestava nas
	// ako su podaci netacni, vraca nas na pocetnu stranu i testira sledece
	// kredencijale iz tabele
	public static void testWADLogin(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE, Constant.SHEET_NAME);
		int brReg = 0;
		int brNeReg = 0;
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillLoginForm(driver, i);
			if (driver.getCurrentUrl().equals("http://localhost/izlet/dashboard.php")) {
				System.out.println("Korisnik iz tabele pod rednim brojem " + i + " je registovan i uspesno ulogovan.");
				brReg += 1;
				driver.findElement(By.xpath("//a[@id='logoutBtn']")).click();
			} // logout button
			else {
				System.out.println("Korisnik iz tabele pod rednim brojem " + i + " nije registrovan, login neuspesan.");
				brNeReg += 1;
				HomePage.goToHomePage(driver);
			}
		}
		System.out.println(
				"Uspesan login za " + brReg + " korisnika iz tabele, nije uspelo za " + brNeReg + " korisnika.");
		// na kraju nam daje izvestaj o broju uspesno i neuspesno ulogovanih
		// uspesno ulogovani su oni sa cijim podacima je uspesno odradjena registracija
	}

	// metoda koja dozvoljava registraciju korisnika preko konzole
	public static void fillRegistrationScanner(WebDriver driver) throws Exception {
		Scanner sc = new Scanner(System.in);
		String f, l, u, e, p;

		System.out.println("Unesite IME:");
		f = sc.nextLine();
		System.out.println("Unesite PREZIME:");
		l = sc.nextLine();
		System.out.println("Unesite USERNAME:");
		u = sc.nextLine();
		System.out.println("Unesite E-MAIL:");
		e = sc.nextLine();
		System.out.println("Unesite PASSWORD:");
		p = sc.nextLine();
		// prvo uzima podatke, a zatim ih koristi za popunjavanje
		HomePage.clickFirstName(driver);
		HomePage.sendKeysFirstName(driver, f);
		HomePage.clickLastName(driver);
		HomePage.sendKeysLastName(driver, l);
		HomePage.clickUsername(driver);
		HomePage.sendKeysUsername(driver, u);
		HomePage.clickEmail(driver);
		HomePage.sendKeysEmail(driver, e);
		HomePage.clickPassword(driver);
		HomePage.sendKeysPassword(driver, p);

		HomePage.clickSubmit(driver);
		sc.close();
		HomePage.goToHomePage(driver);
		// nakon toga se uloguje sa tim podacima
		HomePage.clickUsernameLogin(driver);
		HomePage.sendKeysUsernameLogin(driver, u);
		HomePage.clickPasswordLogin(driver);
		HomePage.sendKeysPasswordLogin(driver, p);

		HomePage.clickLogin(driver);
	}

	// metoda koja popunjava registracionu formu koristeci podatke jednog korisnika
	// iz tabele
	public static void fillRegistrationForm(WebDriver driver, int i) throws Exception {
		String text;
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE, Constant.SHEET_NAME);

		HomePage.clickFirstName(driver);
		text = ExcelUtils.getCellData(i, 0);
		HomePage.sendKeysFirstName(driver, text);

		HomePage.clickLastName(driver);
		text = ExcelUtils.getCellData(i, 1);
		HomePage.sendKeysLastName(driver, text);

		HomePage.clickUsername(driver);
		text = ExcelUtils.getCellData(i, 2);
		HomePage.sendKeysUsername(driver, text);

		HomePage.clickEmail(driver);
		text = ExcelUtils.getCellData(i, 3);
		HomePage.sendKeysEmail(driver, text);

		HomePage.clickPassword(driver);
		text = ExcelUtils.getCellData(i, 4);
		HomePage.sendKeysPassword(driver, text);

		HomePage.clickSubmit(driver);

	}

	// metoda koja prolazi kroz celu tabelu (WithAllData) za REGISTRACIJU
	// vrsi registraciju svih korisnika koji su u tabeli
	public static void testWADRegistration(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE, Constant.SHEET_NAME);

		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillRegistrationForm(driver, i);
			HomePage.goToHomePage(driver);
		}
	}

	// metoda koja prvo ide kroz tabelu i pokusava registraciju za sve korisnike
	// a zatim testira da li su registracije bile uspesne preko login metode
	public static void testWADRegLog(WebDriver driver) throws Exception {
		testWADRegistration(driver);
		testWADLogin(driver);
	}

}
