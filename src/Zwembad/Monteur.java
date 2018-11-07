package Zwembad;

public class Monteur {
	final static int reparatiePrijs = 500;
	final static int onderhoudPrijs = 100;
	
	void onderhouden(Onderhoudbaar o) {
		o.onderhouden(100);
	}
	void repareren (Onderhoudbaar o) {
		o.repareren(false, 100);
	}	
}
