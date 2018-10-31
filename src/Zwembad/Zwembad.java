package Zwembad;

import java.util.ArrayList;
import java.util.Scanner;

public class Zwembad {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Onderdeel> Onderdelen = new ArrayList<>();
	String naam;
	int veiligswaarde;
	int toegangsprijs;		
	
	Zwembad (String n) {
		naam = n;
	}
	
	Kassa kassa = new Kassa();
	
	
	void opening() {
		Onderdelen.add(new Bad(1250, 25, 8));
		System.out.println("Goedemorgen! Het is " + DagGenerator.setWeekdag().dagVanDeWeek + ", tijd om het zwembad te openen\nHoeveel entree wil je vragen?");
		int invoer = sc.nextInt();
		toegangsprijs = invoer;
		sc.nextLine();
		System.out.println(toegangsprijs);
	}
	
	void stap () {
		for(int uur = 8 ; uur < 17; uur++) {
			int tempBezoekers = BezoekerGenerator.gegenereerdeBezoekers(setPopulariteitOnderdelen());
			System.out.println("Het is " + uur + ":00 uur. Dit uur komen er " + tempBezoekers + " bezoekers.");
			kassa.setBezoekersOverzicht(tempBezoekers);
			sc.nextLine();
		}
		kassa.setOmzet(toegangsprijs);
		kassa.getBezoekersOverzicht();
		System.out.println(kassa.getOmzet());
	}
	
	int setPopulariteitOnderdelen() {
		int populariteitOnderdelen = 0;
		for(int i = 0; i < Onderdelen.size(); i++) {
			populariteitOnderdelen += Onderdelen.get(i).populariteit;
		}
		return populariteitOnderdelen;
	}
}
