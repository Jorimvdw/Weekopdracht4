package Zwembad;


public class Bad extends Onderdeel implements Onderhoudbaar{
	boolean kapot = false;
	int kansOpKapot = 100;
		
	Bad (int o, int k, int p) {
		super(o, k, p);
	}
	
	void kansOpKapot() {
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
