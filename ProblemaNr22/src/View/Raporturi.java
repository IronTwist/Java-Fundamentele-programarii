package View;

import Model.*;

public class Raporturi {
	
	
	public static void showAll(ImportCarbune Imp[]) {
		
		CapTabel.capTabelAll();
		
		int i = 0;
		
		while(i < Imp.length) {
			String s[] = new String[2];
			s[0] = Imp[i].getNumeTara();
			long cant = Imp[i].getImportLunar();
			s[1] = Long.toString(cant);
			System.out.print("\t\t"+i);
			System.out.printf("|%-10s|%-10s tep|\n", s);		//afisare formatata
			i++;
		}
	}//end showAll
	
	public static void showProcentual(ImportCarbune Imp[]) {
	
		int i = 0;
		int total = 0;
		
		while(i < Imp.length) {									//aflu total import
			total += Imp[i].getImportLunar();
			i++;
		}//end aflare total importuri
		
		i = 0;
		while(i < Imp.length) {									//setez procentaj pentru fiecare tara
			long cantImp = Imp[i].getImportLunar();
			double proc =((double) cantImp / total) * 100;		
			Imp[i].setProcentImport(proc);
			i++;
		}
		
		Sortari.sortareProcent(Imp);  						//Sortez in functie de procent
		
		CapTabel.capTabelProcentual();
		i=0;
		while(i < Imp.length) {
			
			String s[] = new String[3];
			s[0] = Imp[i].getNumeTara();
			long cant = Imp[i].getImportLunar();
			s[1] = Long.toString(cant);
			double procentaj = Imp[i].getProcentImport();
			s[2] = Double.toString(procentaj);
			System.out.printf("\t\t|%-10s|%-10s tep|%2.5s      |\n", s);
			
			i++;
		}///end afisare tabel cu procente
		
		System.out.println("\t\t\tTotal importuri: "+ total);
		
	}// end showProcentual

}//end raporturi
