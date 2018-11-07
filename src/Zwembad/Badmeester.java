package Zwembad;

import java.util.ArrayList;

public class Badmeester {
	ArrayList<Integer> salarisGeschiedenis = new ArrayList<>();
	int uurPrijs = 30;
	
	void setTotaalSalaris(int openingsUur, int sluitingsUur) {
		salarisGeschiedenis.add(salarisOntvangen(openingsUur, sluitingsUur));
	}
	
	int getTotaalSalaris() {
		int totaalSalaris = 0;
		for(int i = 0; i < salarisGeschiedenis.size(); i++) {
			totaalSalaris += salarisGeschiedenis.get(i);
		}
		return totaalSalaris;
	}
	
	int salarisOntvangen(int openingsUur, int sluitingsUur) {
		int salaris = 0;
		salaris = (sluitingsUur - openingsUur) * uurPrijs;
		return salaris;
	}
}

