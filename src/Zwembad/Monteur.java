package Zwembad;

public class Monteur {

	void onderhouden(Onderhoudbaar o) {
		o.onderhouden(100);
	}
	void repareren (Onderhoudbaar o) {
		o.repareren(false, 100);
	}
	
}
