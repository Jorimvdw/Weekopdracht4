package Zwembad;


import java.util.Random;

public class BezoekerGenerator {
	static Random rand = new Random();
	
	static int gegenereerdeBezoekers(int populariteitOnderdelen) {
		int	gegenereerdeBezoekers = (populariteitOnderdelen + DagGenerator.setWeekdag().dagPopulariteit) * (rand.nextInt(5) + 1);
		return gegenereerdeBezoekers;
	}
}
