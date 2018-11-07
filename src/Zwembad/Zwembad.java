package Zwembad;

import java.util.ArrayList;
import java.util.Scanner;

public class Zwembad {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Onderdeel> Onderdelen = new ArrayList<>();
	String naam;
	int veiligheidswaarde;
	int toegangsprijs;		
	
	Zwembad (String n) {
		naam = n;
	}
	
	Kassa kassa = new Kassa();
	
	void dag() {
		opening();
		stap(8,11);
		
	}
	
	void opening() {
		Onderdelen.add(new Bad(1000, 25, 8));
		System.out.println("Goedemorgen! Het is " + DagGenerator.setWeekdag().dagVanDeWeek + ", tijd om het zwembad te openen\nHoeveel entree wil je vragen?");
		int invoer = sc.nextInt();
		toegangsprijs = invoer;
		sc.nextLine();
		System.out.println(toegangsprijs);
		System.out.println("U heeft " + aantalBadmeestersNodig() + " badmeesters nodig.\nHoeveel wilt u er inhuren?");
		invoer = sc.nextInt();
		veiligheidswaarde = setVeiligheidswaarde(invoer);
		sc.nextLine();
		System.out.println(veiligheidswaarde);
	}
	
	void stap (int openingsUur, int sluitingsUur) {
		for(int uur = openingsUur ; uur < sluitingsUur; uur++) {
			int tempBezoekers = BezoekerGenerator.gegenereerdeBezoekers(setPopulariteitOnderdelen());
			System.out.println("Het is " + uur + ":00 uur. Dit uur komen er " + tempBezoekers + " bezoekers.");
			kassa.setBezoekersOverzicht(tempBezoekers);
			System.out.println(kansOpCalamiteit(veiligheidswaarde));
			
			sc.nextLine();
			
		}
		
	}
	
	void slijtageOnderdelen (Onderdeel... O ) {
		for (Onderdeel On : O) {
			if (On instanceof Onderhoudbaar) {
				On.kansOpKapot -= 10;
				((Onderhoudbaar)On).kansOpKapot();
				
			}
		
		}
	}
	
	

	int setPopulariteitOnderdelen() {
		int populariteitOnderdelen = 0;
		for(int i = 0; i < Onderdelen.size(); i++) {
			populariteitOnderdelen += Onderdelen.get(i).populariteit;
		}
		return populariteitOnderdelen;
	}
	
	boolean kansOpCalamiteit(int veiligheidswaarde) {
		int vw = veiligheidswaarde;
		if (vw >= 100) {
			vw = 99;
		}				
		if ((BezoekerGenerator.rand.nextInt(100) + 1) > vw) {
			return true;
		}
		return false;
	}
	
	int setVeiligheidswaarde (int aantalGehuurdeBadmeesters) {
		int totaalVeiligheidswaarde = (100/aantalBadmeestersNodig()) * aantalGehuurdeBadmeesters ;
		return totaalVeiligheidswaarde;
	}
	int aantalBadmeestersNodig () {
		int aantalBadmeestersNodig = getTotaalOppervlakte() / 500;		
		return aantalBadmeestersNodig;
	}
	
	int getTotaalOppervlakte() {
		int totaalOppervlakte = 0;		
		for (int a = 0; a < Onderdelen.size() ; a++) {
			totaalOppervlakte += Onderdelen.get(a).oppervlakte;
		}
		return totaalOppervlakte;		
	}
}

