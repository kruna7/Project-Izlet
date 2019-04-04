package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import page.objects.Dashboard;
import utility.Constant;
import utility.ExcelUtils;

public class DashboardTest {

	// metoda koja izbacuje objavu koristeci podatke iz tabele
	public static void fillPost(WebDriver driver, int i) throws Exception {
		String text;
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE, Constant.SHEET_NAME2);

		Dashboard.makeAPost(driver);
		Thread.sleep(1000); // cekamo da se otvori prozor
		Dashboard.clickTitle(driver);
		text = ExcelUtils.getCellData(i, 1); // saljemo podatke iz tabele - naziv
		Dashboard.sendKeysTitle(driver, text);

		Dashboard.clickLocation(driver);
		text = ExcelUtils.getCellData(i, 2);
		Dashboard.sendKeysLocation(driver, text);

		Dashboard.clickDescription(driver);
		text = ExcelUtils.getCellData(i, 0);
		Dashboard.sendKeysDescription(driver, text);

		Dashboard.clickPost(driver);
	}

	// metoda pravi objave na sajtu dokle god ima podataka u tabeli
	public static void postALL(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE, Constant.SHEET_NAME2);

		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillPost(driver, i);
		}
	}

	// metoda koja dozvoljava korisniku da napravi objavu sa podacima koji nisu u
	// tabeli vec koje rucno unosi preko konzole
	public static void fillPostScanner(WebDriver driver) throws Exception {
		Scanner sc = new Scanner(System.in);
		String t, l, d;
		int sel;
		Dashboard.makeAPost(driver);
		Thread.sleep(1000); // cekamo da se otvori prozor
		System.out.println("Unesite NALSOV:");
		t = sc.nextLine();
		Dashboard.clickTitle(driver);
		Dashboard.sendKeysTitle(driver, t);

		System.out.println("Unesite LOKACIJU:");
		l = sc.nextLine();
		Dashboard.clickLocation(driver);
		Dashboard.sendKeysLocation(driver, l);

		System.out.println("Unesite zeljeni TRANSPORT:");
		System.out.println("1. Peske");
		System.out.println("2. Kolima");
		System.out.println("3. Motorciklom");
		System.out.println("4. Biciklom");
		System.out.println("5. Autobusom");
		sel = sc.nextInt();
		switch (sel) {
		case 1:
			Dashboard.selectTransport(driver, "Walk");
			break;
		case 2:
			Dashboard.selectTransport(driver, "Car");
			break;
		case 3:
			Dashboard.selectTransport(driver, "Motorbike");
			break;
		case 4:
			Dashboard.selectTransport(driver, "Bicycle");
			break;
		case 5:
			Dashboard.selectTransport(driver, "Bus");
			break;
		default:
			Dashboard.selectTransport(driver, "Car");
			break;
		}
		sc.nextLine();
		System.out.println("Unesite OPIS:");
		d = sc.nextLine();
		Dashboard.clickDescription(driver);
		Dashboard.sendKeysDescription(driver, d);

		Dashboard.clickPost(driver);
		sc.close();
	}

	// metoda koja brise objave
	// prvo se postavlja pitanje korisniku koliko objava zeli da obrise
	public static void deletePost(WebDriver driver) throws Exception {
		// ucitavamo ukupan broj objava ulogovanog korisnika
		int duzLis = Dashboard.myPost(driver);
		System.out.println("Trenutno ima "+duzLis+" vasih objava.");
		System.out.println("Koliko objava zelite da obrisete?");
		Scanner sc = new Scanner(System.in);
		int koliko = sc.nextInt();
		if (koliko < 0) //ako trazi da obrisemo negativan broj objava
			System.out.println("2. Uneli ste broj manji od nule. Vase objave nece biti obrisane.");
		//zatim se poredi broj koji je unet sa brojem korisnikovih objava
		else if (koliko > duzLis) {
			System.out.println("Uneli ste ili broj koji odgovara broju vasih obajava, ili broj veci nego sto ima vasih objava. Obrisacemo sve vase objave.");
			//ako je uneo veci broj, izbacujemo gresku
			for (int i = 0; i < duzLis; i++) {
				Dashboard.clickDeletePost(driver);
				Thread.sleep(1000);
			}
		} else { //u slucaju da je izbacio manji broj od ukupnog broja njegovih objava, brisemo samo toliko
			for (int i = 0; i < koliko; i++) {
				Dashboard.clickDeletePost(driver);
				Thread.sleep(1000);
			}
		}
		sc.close();
	}

	// metoda za editovanje posta, bira se sta menjamo,
	// a zatim kad ukucamo novi tekst, on zameni stari
	public static void editPost(WebDriver driver) throws Exception {
		Scanner sc = new Scanner(System.in);
		int broj;
			System.out.println("Unesite broj onoga sto biste zelieli da izmenite:");
			System.out.println("1. NASLOV");
			System.out.println("2. LOKACIJA");
			System.out.println("3. TRANSPORT");
			System.out.println("4. OPIS");
			broj = sc.nextInt();
			switch (broj) {
			case 1:
				System.out.println("Unesite novi NASLOV");
				sc.nextLine();
				String t = sc.nextLine();
				Dashboard.clickEditPost(driver);
				Thread.sleep(1000);
				Dashboard.clickChangeTitle(driver);
				Dashboard.sendKeysCtrlATitle(driver);
				Dashboard.sendKeysChangeTitle(driver, t);
				Dashboard.clickConfirmChange(driver);
				break;
			case 2:
				System.out.println("Unesite novu LOKACIJU");
				sc.nextLine();
				String l = sc.nextLine();
				Dashboard.clickEditPost(driver);
				Dashboard.clickChangeLocation(driver);
				Dashboard.sendKeysCtrlALocation(driver);
				Dashboard.sendKeysChangeLocation(driver, l);
				Dashboard.clickConfirmChange(driver);
				break;
			case 3:
				System.out.println("Unesite drugi TRANSPORT:");
				System.out.println("1. Peske");
				System.out.println("2. Kolima");
				System.out.println("3. Motorciklom");
				System.out.println("4. Biciklom");
				System.out.println("5. Autobusom");
				int sel;
				sel = sc.nextInt();
				Dashboard.clickEditPost(driver);
				
				switch (sel) {
				case 1:
					Dashboard.selectChangeTransport(driver, "Walk");
					break;
				case 2:
					Dashboard.selectChangeTransport(driver, "Car");
					break;
				case 3:
					Dashboard.selectChangeTransport(driver, "Motorbike");
					break;
				case 4:
					Dashboard.selectChangeTransport(driver, "Bicycle");
					break;
				case 5:
					Dashboard.selectChangeTransport(driver, "Bus");
					break;
				default:
					Dashboard.selectChangeTransport(driver, "Car");
					break;
					}
				Dashboard.clickConfirmChange(driver);
				break;
			case 4:
				System.out.println("Unesite nov OPIS");
				sc.nextLine();
				String d = sc.nextLine();
				Dashboard.clickEditPost(driver);
				Dashboard.clickChangeDescription(driver);
				Dashboard.sendKeysCtrlADescription(driver);
				Dashboard.sendKeysChangeDescription(driver, d);
				Dashboard.clickConfirmChange(driver);
				break;

			} sc.close();
		 
	}
}
