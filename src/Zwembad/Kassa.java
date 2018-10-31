package Zwembad;

import java.util.*;

public class Kassa {
	private int omzet;
	private ArrayList<Integer> bezoekersOverzicht = new ArrayList<>();
	
	int getOmzet() {
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
	
	void getBezoekersOverzicht() {
		for(int i = 0; i < bezoekersOverzicht.size(); i++) {
			System.out.println("Het aantal bezoekers tussen " + (i + 8) + ":00 en " + (i + 9) + ":00 is :\t" + bezoekersOverzicht.get(i));
		}
		int tempBezoekers = 0;
		for(int j = 0; j < bezoekersOverzicht.size(); j ++) {
			tempBezoekers += bezoekersOverzicht.get(j);
		}
		System.out.println("Het totaal aantal bezoekers is " + tempBezoekers);
	}
	
	void Dagrapport() {
	//	kassa.setOmzet(toegangsprijs);
		//kassa.getBezoekersOverzicht();
		//System.out.println(kassa.getOmzet());
	}
}
