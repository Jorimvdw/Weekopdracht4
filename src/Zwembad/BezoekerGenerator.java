package Zwembad;


import java.util.Random;

public class BezoekerGenerator {
	static Random rand = new Random();
	
	static int gegenereerdeBezoekers(int populariteit) {
		int	gegenereerdeBezoekers = populariteit * (rand.nextInt(5) + 1);
		return gegenereerdeBezoekers;
	}
}
