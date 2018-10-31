package Zwembad;

import java.util.ArrayList;
import java.util.Scanner;

public class Zwembad {
	ArrayList<Onderdeel> Onderdelen = new ArrayList<>();
	String naam;
	int populariteit;
	int veiligswaarde;
	int toegangsprijs;		
	
	Zwembad (String n) {
		naam = n;
	}
	
	Kassa kassa = new Kassa();
	
	
	void opening() {
		Onderdelen.add(new Bad(1250, 25, 8));
		System.out.println("Goedemorgen! Tijd om het zwembad te openen\nHoeveel entree wil je vragen?");
		Scanner sc = new Scanner(System.in);
		int invoer = sc.nextInt();
		toegangsprijs = invoer;
		System.out.println(toegangsprijs);
	}
	
	void stap () {
		System.out.println("Het is 8 uur. Dit uur komen er " + BezoekerGenerator.gegenereerdeBezoekers(populariteit) + " bezoekers.");
	}
	
}
