package start;

public class Message {

	public static void options() {
		//poruka sa opcijama 
		System.out.println("Izaberite opciju koju zelite (ukucajte redni broj opcije):");
		System.out.println("1. Login sa podacima koje unosite preko konzole.");
		System.out.println("2. Login sa podacima prve osobe iz tabele.");
		System.out.println("3. Test za login za sve osobe iz tabele. Daje podatke o broju uspesno ulogovanih.");
		System.out.println("4. Registracija sa podacima koje unosite preko konzole i automatski login.");
		System.out.println("5. Pokusaj registracije svih korisnika iz tabele, bez povratnih informacija o uspesnosti testa.");
		System.out.println("6. Test koji registruje, a zatim pokusava login za sve korisnike iz tabele.");
		System.out.println("7. Login sa kredencijalima prve osobe iz tabele i objavljivanje svih objava iz tabele.");
		System.out.println("8. Login sa kredencijalima prve osobe iz tabele i objavljivanje objave sa kustomizovanim podacima.");
		System.out.println("9. Brisanje poslednjih objava. Moguce izabrati koliko objava zelite da obrisete.");
		System.out.println("10. Menjanje poslednjeg posta koji je korisnik uneo.");
	}
}
