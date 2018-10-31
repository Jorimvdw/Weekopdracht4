package Zwembad;

import java.util.*;

public class DagGenerator {
	static List<Weekdag> weekDagen = Arrays.asList(new Weekdag("Maandag", 10), new Weekdag("Dinsdag", 12), new Weekdag("Woensdag", 25), new Weekdag("Donderdag", 15)
											, new Weekdag("Vrijdag", 17), new Weekdag("Zaterdag", 40), new Weekdag("Zondag", 35));

	static Weekdag setWeekdag() {
		Random rand = new Random();
		Weekdag weekdag = weekDagen.get(rand.nextInt(7));
		return weekdag;
	}
}

class Weekdag{
	String dagVanDeWeek;
	int dagPopulariteit;
	
	Weekdag(String dagVanDeWeek, int dagPopulariteit){
		this.dagVanDeWeek = dagVanDeWeek;
		this.dagPopulariteit = dagPopulariteit;
	}
}
