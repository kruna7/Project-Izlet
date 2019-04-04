package start;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.objects.HomePage;
import page.tests.DashboardTest;
import page.tests.HomePageTest;

public class MainClass {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new FirefoxDriver();
		try {
			Message.options(); //izbacuje tekst sa opcijama
			HomePage.openHomePage(driver);
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
			case 1:
				HomePageTest.fillLoginScanner(driver);
			case 2:
				HomePageTest.fillLoginForm(driver, 1); 
				break;
			case 3:
				HomePageTest.testWADLogin(driver);
				break;
			case 4:
				HomePageTest.fillRegistrationScanner(driver);
				break;
			case 5:
				HomePageTest.testWADRegistration(driver);
				break;
			case 6:
				HomePageTest.testWADRegLog(driver);
				break;
			case 7:
				HomePageTest.fillLoginForm(driver, 1); // neophodno je prvo da se ulogujemo kako bi objavljivali
				DashboardTest.postALL(driver); 
				break;
			case 8:
				HomePageTest.fillLoginForm(driver, 1); 
				DashboardTest.fillPostScanner(driver);
				break;
			case 9:
				HomePageTest.fillLoginForm(driver, 1);
				DashboardTest.deletePost(driver);
				break;
			case 10:
				HomePageTest.fillLoginForm(driver, 1);
				DashboardTest.editPost(driver);
				break;
			default:
				System.out.println("Uneli ste nevazeci broj.");
				break;
			}
			sc.close();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Thread.sleep(10000);
			driver.close();
		}
	}

}
