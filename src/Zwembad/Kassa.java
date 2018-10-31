package Zwembad;


public class Kassa {
	private double omzet;
	private int[] bezoekersOverzicht = new int[3];
	
	
	double getOmzet(double toegangsprijs) {
		int totaalBezoekers = 0;
		for(int i = 0; i < bezoekersOverzicht.length; i++) {
			totaalBezoekers += bezoekersOverzicht[i];
		}
		double omzet = totaalBezoekers * toegangsprijs;
		return omzet;
	}
	
	public void setOmzet(double omzet) {
		this.omzet = omzet;
	}
	
	
	
}
