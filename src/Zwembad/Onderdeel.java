package Zwembad;


public abstract class Onderdeel {
	int oppervlakte;
	int kostenPerM2;
	int populariteit;
	
	Onderdeel(int o, int k, int p) {
		oppervlakte = 0;
		kostenPerM2 = k;
		populariteit = p;
	}
}

