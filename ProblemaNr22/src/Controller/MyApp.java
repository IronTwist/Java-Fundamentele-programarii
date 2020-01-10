package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import Model.*;
import View.*;

public class MyApp {
	
	public static String keyboardRead(String str) {								//citire date tastatura
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

		if(imp == null) {														//adaug tari daca nu am importat lista anterior
			
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
			
		}else {																//daca am importat fisierul text atunci doar adaug datele in lista
					
			ImportCarbune listaUpdate[] = new ImportCarbune[imp.length+1]; 
			
			for (int i = 0; i < listaUpdate.length; i++) {			
				
					if(i == listaUpdate.length-1) {
						listaUpdate[i] = new ImportCarbune();
						listaUpdate[i].setNumeTara(keyboardRead("Introdu numele tarii: "));
						listaUpdate[i].setImportLunar(Long.parseLong(keyboardRead("Cate tep: ")));
					}else {
						listaUpdate[i] = imp[i];
					}
			}
			return listaUpdate;
		}
		
		return imp;
	}//end citire date
	
	public static ImportCarbune[] citireDinFisier() {
		
		int n;	//numar linii din fisier
		ImportCarbune lista[] = null;
		
		try {
			BufferedReader fisierIn = new BufferedReader(new FileReader("F:\\MyWork\\Java Fundamentele programarii\\ProblemaNr22\\src\\BazaDeDate\\ImportCarbune.txt"));	//citesc fisier
			String s;	//string s
			s = fisierIn.readLine(); //atasez la string s prima linie
			n = Integer.parseInt(s);	//parsez din string la int si transfer in n pentru a sti cate linii avem
			
			lista = new ImportCarbune[n]; //aloca n referinte pentru fiecare tara
			
			System.out.println("n= " + lista.length); 	
			
			int i = 0;
			
				while((s = fisierIn.readLine()) != null) {			
					String bucati[] = s.split(",");					// impart Stringul s 
					
					String nume = bucati[0];							
					
					long nota = Long.parseLong(bucati[1]);
					
					lista[i] = new ImportCarbune();						//pentru fiecare tara adaug informatiile necesare
					lista[i].setNumeTara(nume);
					lista[i].setImportLunar(nota);
					
					i++;										//incrementez pentru urmatorul
				}//end while
			System.out.println("Lungimea tabelului= "+lista.length);
			fisierIn.close();
		}//end try
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}//end catch 
		return lista;
	}//end citireDinFisier()
	
	
	public static int Menu() {													//functie afisare meniu
		System.out.println("\n1. Incarcare date din fisier");
		System.out.println("2. Citire date tastatura");
		System.out.println("3. Afisare importuri");
		System.out.println("4. Sortare alfabetica");
		System.out.println("5. Sortare descrascatoare dupa importul lunar de carbune");
		System.out.println("6. Exit");
		String opt = keyboardRead("Alege optiune: ");
		return Integer.parseInt(opt);
	}//end Menu

	public static void main(String[] args) {
		int opt = Menu();
		
		ImportCarbune listaImporturi[] = null;
		
		do {
			
			switch(opt) {
				case 1:																	//importare din fisier
						listaImporturi = citireDinFisier();
						System.out.println("Datele din fisier s-au incarcat cu succes");
						break;
				case 2:																	//adaugare date de la tastatura
						listaImporturi = adaugareDateimport(listaImporturi);
						System.out.println("Am finalizat citirea datelor");
						break;
				case 3:	if(listaImporturi == null) {
							System.out.println("\t\tAtentie baza de date este nula!");
							break;
						}																//afisare importuri
						Raporturi.showAll(listaImporturi);
						break;
				case 4:	if(listaImporturi == null) {									//sortare importuri alfabet
							System.out.println("\t\tAtentie baza de date este nula!");
							break;
						}
						System.out.println("\t\t  Afisare sortata alfabetic");
						Sortari.sortareAlfabetica(listaImporturi);
						Raporturi.showAll(listaImporturi);
						break;
				case 5:																	//Sortare descrascatoare dupa importul lunar de carbune
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
		}while(opt != 6);		//end while
		
		System.out.println("Program terminat");

	}//end main

}//end class



















