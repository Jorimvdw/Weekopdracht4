package Zwembad;

public class Bad extends Onderdeel implements Onderhoudbaar{
		
	Bad (int o, int k, int p) {
		super(o, k, p);
	}
	
	public void kansOpKapot() {
		if ((BezoekerGenerator.rand.nextInt(100) + 1) > kansOpKapot) {
			kapot = true;
		}
	}
	
	public void onderhouden(int a) {
		kansOpKapot = a;
	}
	
	public void repareren(boolean a, int b) {
		kapot = a;
		kansOpKapot = b;
	}
	
}

class Bubbelbad extends Bad {
	Bubbelbad (int o, int k, int p) {
		super(o, k, p);
	}
}

class Golfslagbad extends Bad {
	Golfslagbad (int o, int k, int p) {
		super(o, k, p);
	}
}

class Wedstrijdbad extends Bad {
	Wedstrijdbad (int o, int k, int p) {
		super(o, k, p);
	}
}
	
