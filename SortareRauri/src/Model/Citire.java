package Model;
import Controller.Run;

public class Citire {
	public static void citiretastatura(Fluviu t[]) {
		//metoda clasa Scanner de citire string : citString
		//metoda clasa Scanner de citire string din Controller.Run
		int n;
		n = Run.citIntreg("Cate fluvii?");
		
		t = new Fluviu[n];
		
		for(int i=0; i < n; i++) {
			String nume= citString("da numele fluviului");
			
			t[i].setNume(nume); 
			
			int lung = Run.citIntreg("da lungime: ");
			t[i].setLungime(lung);
		}
		
		
	}
	
	public static void citireFisier(Fluviu t[]) {
		
	}
}
