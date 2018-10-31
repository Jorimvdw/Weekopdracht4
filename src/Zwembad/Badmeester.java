package Zwembad;

public class Badmeester {
	int veiligheidswaarde;
	int prijs;
	

	
	boolean kansOpCalamiteit(int veiligheidswaarde) {
		int vw = veiligheidswaarde;
		if (vw == 100) {
			vw = 99;
		}				
		if ((BezoekerGenerator.rand.nextInt(100) + 1) > vw) {
			return true;
		}
		return false;
	}
	
	int getVeiligheidswaarde (int aantalGehuurdeBadmeesters) {
		int totaalVeiligheidswaarde = (100/aantalBadmeestersNodig()) * aantalGehuurdeBadmeesters ;
		return totaalVeiligheidswaarde;
	}
	
	int aantalBadmeestersNodig () {
		int aantalBadmeestersNodig = getTotaalOppervlakte() / 500;		
		return aantalBadmeestersNodig;
	}
	
	int getTotaalOppervlakte() {
		int totaalOppervlakte;
		for (Onderdeel o : Zwembad.Onderdelen) {
			totaalOppervlakte += o.oppervlakte;
		}
		return totaalOppervlakte;		
	}

}

