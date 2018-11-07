package Zwembad;

import java.util.*;

public class Kassa {
	private int omzet;
	int kostenOnderhoudReparatie;

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
	
	void setBezoekersOverzicht() {
		bezoekersOverzicht.clear();
	}
	
	int getBezoekersOverzicht() {
		for(int i = 0; i < bezoekersOverzicht.size(); i++) {
//			System.out.println("Het aantal bezoekers tussen " + (i + 8) + ":00 en " + (i + 9) + ":00 is :\t" + bezoekersOverzicht.get(i));
		}
		int tempBezoekers = 0;
		for(int j = 0; j < bezoekersOverzicht.size(); j ++) {
			tempBezoekers += bezoekersOverzicht.get(j);
		}
//		System.out.println("Het totaal aantal bezoekers is " + tempBezoekers);
		return tempBezoekers;
	}
	
	void betaalBadMeester(int openingsUur, int sluitingsUur, ArrayList<Badmeester> badmeester) {
		for(int j = 0; j < badmeester.size(); j++) {
			badmeester.get(j).setTotaalSalaris(openingsUur, sluitingsUur);
		}
	}
	
	int totaalSalarisBadmeester(ArrayList<Badmeester> badmeester) {
		int totaalSalarisBadmeester = 0;
		for(int i = 0; i < badmeester.size(); i++) {
			totaalSalarisBadmeester += badmeester.get(i).getTotaalSalaris();
		}
		return totaalSalarisBadmeester;
	}
	
	void clearWaardes() {
		setOmzet(0);
		setBezoekersOverzicht();
		kostenOnderhoudReparatie = 0;
	}
		
	void maakDagRapport(String dagVanDeWeek, int totaalSalarisBadmeester, int toegangsprijs, ArrayList<Badmeester> badmeester) {
		DagRapport rapport = new DagRapport(dagVanDeWeek, getBezoekersOverzicht(), getOmzet(toegangsprijs), totaalSalarisBadmeester(badmeester), kostenOnderhoudReparatie);
		dagRapporten.add(rapport);
	}
	
	void toonDagRapport() {
		for(int i = 0; i < dagRapporten.size(); i++) {
			System.out.println("\nDagrapport dag\t " + (i + 1) + ":");
			System.out.println("Dag: \t\t\t\t" + dagRapporten.get(i).dagVanDeWeek);
			System.out.println("Totaal aantal bezoekers: \t" + dagRapporten.get(i).totaalAantalBezoekers);
			System.out.println("Dag omzet: \t\t\t€" + dagRapporten.get(i).dagOmzet);
			System.out.println("Totaal salaris badmeester is \t€" + dagRapporten.get(i).totaalSalarisBadmeester);
			System.out.println("Totale kosten onderhoud zijn \t€" + dagRapporten.get(i).kostenOnderhoudReparatie);
			System.out.println("\nDag winst: \t\t\t€" + dagRapporten.get(i).dagWinst);
		}
	}
}

class DagRapport {
	String dagVanDeWeek;
	int totaalAantalBezoekers;
	int dagOmzet;
	int totaalSalarisBadmeester;
	int kostenOnderhoudReparatie;
	int dagWinst = dagOmzet - (totaalSalarisBadmeester + kostenOnderhoudReparatie);
	
	DagRapport(String dagVanDeWeek, int totaalAantalBezoekers, int dagOmzet, int totaalSalarisBadmeester, int kostenOnderhoudReparatie) {
		this.dagVanDeWeek = dagVanDeWeek;
		this.totaalAantalBezoekers = totaalAantalBezoekers;
		this.dagOmzet = dagOmzet;
		this.totaalSalarisBadmeester = totaalSalarisBadmeester;
		this.kostenOnderhoudReparatie = kostenOnderhoudReparatie;
		this.dagWinst = dagOmzet - (totaalSalarisBadmeester + kostenOnderhoudReparatie);
	}
}