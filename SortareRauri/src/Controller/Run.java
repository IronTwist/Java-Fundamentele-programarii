package Controller;
import Model.*;
import java.util.Scanner;

import Model.Fluviu;
//Controler
public class Run {
	
	public static int citIntreg(String str) {					//returnare optiune meniu
		System.out.print(str);
		try {
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			int x = keyboard.nextInt();
			return x;
			
		}catch(Exception exp){
			System.out.println("Atentie!");
			return citIntreg(str);
		}
		
	}
	
	public static int Meniu() {									//fnct. de afisare meniu
		System.out.println("\n1. Citire date tastatura");
		System.out.println("2. Citire date din fisier");
		System.out.println("3. Afisare alfabetica");
		System.out.println("4. Afisare procentuala, lungimi");
		System.out.println("0. Terminare program");
		return citIntreg("Alege o optiune: ");
	}

	public static void main(String[] args) {

			
		int opt = Meniu();
		Fluviu[] tablou= null;
		while(opt != 0){	
			
			switch(opt) {
				case 1: //citire date tastatura din Model
						Citire.citiretastatura(tablou);
						break;
				case 2: //citire date din fisier
						Citire.citireFisier(tablou);
						break;
				case 3: //afisare alfabetica	din View
						break;
				case 4: //afisare procentuala		din View
						break;
				default:
					System.out.println("Eroare optiune!");
			}//end switch
			opt = Meniu();
		}//end while	
		
		System.out.println("Program terminat");
		
		
		
		
	}// end main

}
