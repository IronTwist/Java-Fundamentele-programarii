package Controller;

import java.util.Scanner;
import Model.*;
import View.*;

public class MyApp {
	
	public static String keyboardRead(String str) {
		System.out.print(str);
		
		try {
			Scanner keyboard = new Scanner(System.in);
			String s = keyboard.next();
			return s;
			
		}catch(Exception e) {
			System.out.println("A aparut o eroare!");
			return keyboardRead(str);
		}
	}//end keyRead
	
	public static ImportCarbune[] adaugareDateimport(ImportCarbune imp[]) {
		
		String n;
		n = keyboardRead("Cate tari? ");
		int nrTari = Integer.parseInt(n);
		
		imp = new ImportCarbune[nrTari];
		
		for(int i = 0; i < nrTari; i++) {
			
			imp[i] = new ImportCarbune();
			System.out.println("Introdu date tara nr " + (i+1) + " :");
			String nume = keyboardRead("Numele tarii: ");
			imp[i].setNumeTara(nume);
			
			String cantImport = keyboardRead("Cate tep(tone echivalent in petrol): ");
			imp[i].setImportLunar(Long.parseLong(cantImport));	
			
		}
		
		return imp;
	}
	
	public static int Menu() {
		System.out.println("\n1. Citire date tastatura");
		System.out.println("2. Afisare importuri");
		System.out.println("3. Sortare alfabetica");
		System.out.println("4. Sortare descrascatoare dupa importul lunar de carbune");
		System.out.println("5. Exit");
		String opt = keyboardRead("Alege optiune: ");
		return Integer.parseInt(opt);
	}//end Menu

	public static void main(String[] args) {
		int opt = Menu();
		
		ImportCarbune listaImporturi[] = null;
		
		do {	
			switch(opt) {
				case 1:																//adaugare date de la tastatura
						listaImporturi = adaugareDateimport(listaImporturi);
						System.out.println("Am finalizat citirea datelor");
						break;
				case 2:	if(listaImporturi == null) {
							System.out.println("\t\tAtentie baza de date este nula!");
							break;
						}																//afisare importuri
						Raporturi.showAll(listaImporturi);
						break;
				case 3:	if(listaImporturi == null) {
							System.out.println("\t\tAtentie baza de date este nula!");
							break;
						}
						System.out.println("\t\t  Afisare sortata alfabetic");
						Sortari.sortareAlfabetica(listaImporturi);
						Raporturi.showAll(listaImporturi);
						break;
				case 4:																	//Sortare descrascatoare dupa importul lunar de carbune
						if(listaImporturi == null) {
							System.out.println("\t\tAtentie baza de date este nula!");
							break;
						}
						Raporturi.showProcentual(listaImporturi);
						//System.out.println("ai ales 4");
						break;
				default:
						System.out.println("\t\tAi ales gresit optiunea!");
			}
			
			opt = Menu();
			
		}while(opt != 5);		//end while
		
		System.out.println("Program terminat");

	}//end main

}//end class



















