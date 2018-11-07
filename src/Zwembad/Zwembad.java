package Zwembad;

import java.util.*;

public class Zwembad {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Onderdeel> Onderdelen = new ArrayList<>();
	ArrayList<Badmeester> badmeesters = new ArrayList<>();
	List<String> calamiteiten = Arrays.asList("Grote vechtpartij in zwembad, meerdere gewonden", "Gewonde gevallen door glijpartij"
											  , "Dode door verdrinking", "Iemand heeft in het bad gepoept");
	String naam;
	int veiligheidswaarde;
	int toegangsprijs;	
	int totaalPopulariteit;
	
	Zwembad (String n) {
		naam = n;
	}
	
	Kassa kassa = new Kassa();
	
	void dag() {
		opening();
		stap(8,15);
		
	}
	
	void opening() {
		Onderdelen.add(new Bad(1000, 25, 30));
		System.out.println("Goedemorgen! Het is " + DagGenerator.setWeekdag().dagVanDeWeek + ", tijd om het " + naam + " te openen\nHoeveel entree wil je vragen?");
		int invoer = sc.nextInt();
		toegangsprijs = invoer;
		sc.nextLine();
		System.out.println("U heeft " + aantalBadmeestersNodig() + " badmeesters nodig om risico tot calamiteiten te minimaliseren.\nHoeveel wilt u er inhuren?");
		invoer = sc.nextInt();
		huurBadMeester(invoer);
		veiligheidswaarde = setVeiligheidswaarde(invoer);
		sc.nextLine();
		setPopulariteitOnderdelen();
	}
	
	void stap (int openingsUur, int sluitingsUur) {
		for(int uur = openingsUur ; uur < sluitingsUur; uur++) {
			int tempBezoekers = BezoekerGenerator.gegenereerdeBezoekers(totaalPopulariteit);
			System.out.println("Het is " + uur + ":00 uur. Dit uur komen er " + tempBezoekers + " bezoekers.");
			kassa.setBezoekersOverzicht(tempBezoekers);
			System.out.println(kansOpCalamiteit(veiligheidswaarde));
			sc.nextLine();
			System.out.println(veiligheidswaarde);
			System.out.println(totaalPopulariteit);
		}
		kassa.betaalBadMeester(openingsUur, sluitingsUur, badmeesters);
	}
	
	void eindeDag() {
		kassa.setOmzet(toegangsprijs);
		System.out.println("Het totaal aantal bezoekers van vandaag " + kassa.getBezoekersOverzicht());
		System.out.println("De totale omzet van vandaag is €" + kassa.getOmzet(toegangsprijs));
		kassa.maakDagRapport(DagGenerator.setWeekdag().dagVanDeWeek, totaalSalarisBadmeester, toegangsprijs);
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
			for(int i = 0; i < Onderdelen.size(); i++) {
				totaalPopulariteit += Onderdelen.get(i).populariteit;
			}
			return totaalPopulariteit;
	}
	
	boolean kansOpCalamiteit(int veiligheidswaarde) {
		int vw = veiligheidswaarde;
		if (vw >= 100) {
			vw = 99;
		}				
		if ((BezoekerGenerator.rand.nextInt(100) + 1) > vw) {
			System.out.println(genereerCalamiteit());
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
	
	void huurBadMeester(int i) {
		for(int j = 0; j < i; j++) {
			badmeesters.add(new Badmeester());
		}
	}
	
	String genereerCalamiteit() {
		if(totaalPopulariteit > 10) {
			totaalPopulariteit -= 10;
		}
		Random rand = new Random();
		return calamiteiten.get(rand.nextInt(calamiteiten.size() - 1));
	}
	
	int getTotaalOppervlakte() {
		int totaalOppervlakte = 0;		
		for (int a = 0; a < Onderdelen.size() ; a++) {
			totaalOppervlakte += Onderdelen.get(a).oppervlakte;
		}
		return totaalOppervlakte;		
	}
}

