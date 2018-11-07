package Zwembad;

interface Onderhoudbaar {
	void onderhouden(int a);
	void repareren(boolean b, int a);
	void kansOpKapot();
	
	default void gebruikOnderhoudbaarOnderdeel(Onderhoudbaar o) throws OnderdeelKapotException {
		if (((Onderdeel)o).kapot == true) {
			throw new OnderdeelKapotException(o);
		} else {
			slijtageOnderdelen(o);
		  }
	}
	
	default void slijtageOnderdelen (Onderhoudbaar o) {
		((Onderdeel)o).kansOpKapot -= 10;
		o.kansOpKapot();
	}		
	
}

class OnderdeelKapotException extends Exception{
	public OnderdeelKapotException(Onderhoudbaar o) {
		System.out.println("Onderdeel " + o.getClass() + " is kapot gegaan.");
	}
}

