package Model;

public class Sortari {
	public static void sortareProcent(ImportCarbune Imp[]) {
		boolean flag;
		int poz = Imp.length - 1;  //5 el -> poz = 4
		
		do {
			flag = true;
			
			for(int i = 0; i < poz; i++) {
				double actual = Imp[i].getProcentImport();
				double urmator = Imp[i+1].getProcentImport();
				if(actual < urmator) {
					ImportCarbune tmp = Imp[i];
					Imp[i] = Imp[i+1];
					Imp[i+1] = tmp;
					flag = false;
				}
			}	
		}while(!flag); //atata timp cat este fals
	}
	
	public static void sortareAlfabetica(ImportCarbune Imp[]) {
		
		boolean flag;
		
		int poz = Imp.length - 1;

		do {
			flag = true;
			for(int i = 0; i < poz; i++) {
				
				String actual = Imp[i].getNumeTara();
				String urmator = Imp[i+1].getNumeTara();
				
				if(actual.compareTo(urmator) > 0) {
					ImportCarbune tmp = Imp[i];
					Imp[i] = Imp[i+1];
					Imp[i+1] = tmp;
					flag = false;
				}
			}
			
		}while(!flag);
	}
}
