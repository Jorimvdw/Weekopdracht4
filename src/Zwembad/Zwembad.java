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
	boolean open = true;
	
	Zwembad (String n) {
		naam = n;
	}
	
	Kassa kassa = new Kassa();
	
	void dag() {
		while(open) {
			String tempNaamDag = opening();
			stap(8,15);
			eindeDag(tempNaamDag);
		}
	}
	
	String opening() {
		Onderdelen.add(new Bad(1000, 25, 30));
		String dagVanWeek = DagGenerator.setWeekdag().dagVanDeWeek;
		System.out.println("Goedemorgen! Het is " + dagVanWeek + ", tijd om het " + naam + " te openen\nHoeveel entree wil je vragen?");
		int invoer = sc.nextInt();
		toegangsprijs = invoer;
		sc.nextLine();
		System.out.println("U heeft " + aantalBadmeestersNodig() + " badmeesters nodig om risico tot calamiteiten te minimaliseren.\nHoeveel wilt u er inhuren?");
		invoer = sc.nextInt();
		huurBadMeester(invoer);
		veiligheidswaarde = setVeiligheidswaarde(invoer);
		sc.nextLine();
		setPopulariteitOnderdelen();
		return dagVanWeek;
	}
	
	void stap (int openingsUur, int sluitingsUur) {
		for(int uur = openingsUur ; uur < sluitingsUur; uur++) {
			int tempBezoekers = BezoekerGenerator.gegenereerdeBezoekers(totaalPopulariteit);
			System.out.println("Het is " + uur + ":00 uur. Dit uur komen er " + tempBezoekers + " bezoekers.");
			kassa.setBezoekersOverzicht(tempBezoekers);
			kansOpCalamiteit(veiligheidswaarde);
			sc.nextLine();
			GebruikOnderdelen();
		}
		kassa.betaalBadMeester(openingsUur, sluitingsUur, badmeesters);
	}
	
	void eindeDag(String dagVanWeek) {
		reparatieOfOnderhoud();
		kassa.setOmzet(toegangsprijs);
		kassa.maakDagRapport(dagVanWeek, kassa.totaalSalarisBadmeester(badmeesters), toegangsprijs, badmeesters);
		System.out.println("Einde van de dag, druk op enter voor de volgende dag. Of q om af te sluiten en de dagrapporten te tonen.");
		String inv = sc.nextLine();
		if(inv.equals("q")) {
			kassa.toonDagRapport();
			open = false;
		} 
		kassa.clearWaardes();
		badmeesters.clear();
		veiligheidswaarde = 0;
		totaalPopulariteit = 0;
		Onderdelen.clear();
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
	
	void kansOpCalamiteit(int veiligheidswaarde) {
		int vw = veiligheidswaarde;
		if (vw >= 100) {
			vw = 99;
		}				
		if ((BezoekerGenerator.rand.nextInt(100) + 1) > vw) {
			System.out.println(genereerCalamiteit());
		}
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
		if(totaalPopulariteit > 20) {
			totaalPopulariteit -= 20;
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
	
	void GebruikOnderdelen () {
		for (Onderdeel o : Onderdelen) {
			if (o instanceof Onderhoudbaar) {
				Onderhoudbaar oh = (Onderhoudbaar) o;
				try {
					oh.gebruikOnderhoudbaarOnderdeel(oh);
				} catch (OnderdeelKapotException e) {
					
				}		
			}		
		}
	}
	
	void reparatieOfOnderhoud() {
		for (Onderdeel o : Onderdelen) {
			if(o.kapot == true) {
				System.out.println("Wilt u een monteur inhuren voor de reparatie? j/n");
				String inv = sc.nextLine();
				if(inv.equals("j")) {
					kassa.kostenOnderhoudReparatie += Monteur.reparatiePrijs;
					new Monteur().repareren((Onderhoudbaar) o); 
				}
			} else if (o.kansOpKapot < 100){
				System.out.println("Wilt u onderhoud uitvoeren aan dit onderdeel?");
				String inv = sc.nextLine();
				if(inv.equals("j")) {
					kassa.kostenOnderhoudReparatie += Monteur.onderhoudPrijs;
					new Monteur().onderhouden((Onderhoudbaar) o); 
				}
			}
		}
	}
}

