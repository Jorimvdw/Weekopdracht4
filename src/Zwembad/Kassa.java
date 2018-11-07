package Zwembad;

import java.util.*;

public class Kassa {
	private int omzet;
	private ArrayList<Integer> bezoekersOverzicht = new ArrayList<>();
	private ArrayList<DagRapport> dagRapporten = new ArrayList<>();
	
	int getOmzet(int toegangsprijs) {
		setOmzet(toegangsprijs);
		return omzet;
	}
	
	void setOmzet(int toegangsprijs) {
		int tempBezoekers = 0;
		for(int i = 0; i < bezoekersOverzicht.size(); i++) {
			tempBezoekers += bezoekersOverzicht.get(i);
		}
		omzet = tempBezoekers * toegangsprijs;
	}

	void setBezoekersOverzicht(int bezoekers) {
		bezoekersOverzicht.add(bezoekers);
	}
	
	int getBezoekersOverzicht() {
		for(int i = 0; i < bezoekersOverzicht.size(); i++) {
			System.out.println("Het aantal bezoekers tussen " + (i + 8) + ":00 en " + (i + 9) + ":00 is :\t" + bezoekersOverzicht.get(i));
		}
		int tempBezoekers = 0;
		for(int j = 0; j < bezoekersOverzicht.size(); j ++) {
			tempBezoekers += bezoekersOverzicht.get(j);
		}
		System.out.println("Het totaal aantal bezoekers is " + tempBezoekers);
		return tempBezoekers;
	}
	
	void betaalBadMeester(int openingsUur, int sluitingsUur, ArrayList<Badmeester> badmeester) {
		for(int j = 0; j < badmeester.size(); j++) {
			badmeester.get(j).setTotaalSalaris(openingsUur, sluitingsUur);
		}
	}
		
	void maakDagRapport(Weekdag dagVanDeWeek, int totaalSalarisBadmeester, int toegangsprijs) {
		DagRapport rapport = new DagRapport(dagVanDeWeek, getBezoekersOverzicht(), getOmzet(toegangsprijs), totaalSalarisBadmeester);
		dagRapporten.add(rapport);
	}
	
	void toonDagRapport() {
		for(int i = 0; i < dagRapporten.size(); i++) {
			System.out.println("Dagrapport dag " + i + ":");
			System.out.println("Dag: \t\t" + dagRapporten.get(i).dagVanDeWeek);
			System.out.println("Totaal aantal bezoekers: \t" + dagRapporten.get(i).totaalAantalBezoekers);
			System.out.println("Dag omzet: \t\t" + dagRapporten.get(i).dagOmzet);
			
			System.out.println("\nDag winst: \t\t" + dagRapporten.get(i).dagWinst);

		}
	}
}

class DagRapport {
	Weekdag dagVanDeWeek;
	int totaalAantalBezoekers;
	int dagOmzet;
	int totaalSalarisBadmeester;
//	int kostenOnderhoud;
//	int kostenReparatie;
	int dagWinst = dagOmzet - (totaalSalarisBadmeester);
	
	DagRapport(Weekdag dagVanDeWeek, int totaalAantalBezoekers, int dagOmzet, int totaalSalarisBadmeester) {
		this.dagVanDeWeek = dagVanDeWeek;
		this.totaalAantalBezoekers = totaalAantalBezoekers;
		this.dagOmzet = dagOmzet;
		this.totaalSalarisBadmeester = totaalSalarisBadmeester;
//		this.kostenOnderhoud = kostenOnderhoud;
//		this.kostenReparatie = kostenReparatie;
	}
}