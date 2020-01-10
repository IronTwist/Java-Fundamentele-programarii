import java.util.Scanner;


public class Problema24OOP {

	public static void main(String[] args) {
		
		int k = 0, optMeniu;
		Vector vectorulMeu = new Vector();
		
		System.out.print("Problema 24: Programare orientata pe obiecte \n");
		System.out.println("\tSe da un vector de numere intregi de lungime n. Se mai da un numar k: 1 < k <n.");
		System.out.println("\tSa se sorteze desrescator primele k componenete ale vectorului, iar celelalte sa se sorteze crescator.\n");
		
		do {
			optMeniu = Functii.meniu();
			
			System.out.println("\n");
						
			switch (optMeniu) {
				case 1: 
						vectorulMeu.setLungime(Functii.citesteNumar("\t\tIntrodu lungime vector: "));
						vectorulMeu.populareVector();
						break;
				case 2:	do{
							k = Functii.citesteNumar("\t\tIntrodu k: ");
							if(k <= 0) {
								System.out.println("\t\tAtentie!! Numarul introdus trebuie sa fie mai mare decat 0");
							}
						}while(k < 1);
						break;
				case 3:	System.out.println("\t\tAfisare vector: ");
							if(vectorulMeu.getLungime() == 0) {
								System.out.println("\t\tAtentie! Nu exista vector");
								break;
							}
						System.out.print("\t\t[");
							vectorulMeu.afisareVector();
						System.out.print(vectorulMeu.getVector()[vectorulMeu.getLungime() - 1] + "]\n");
						break;
				case 4: 
						if(vectorulMeu.getLungime() <= k) {
							System.out.println("\t\tAtentie! k trebuie sa fie mai mic decat lungimea vectorului");
							break;
						}
						vectorulMeu.setVector(Functii.sortareVect(vectorulMeu.getVector(), k));	
						break;		
				case 5: continue;
				
				default: System.out.println("\n\t\t Atentie! Optiunea aleasa este incorecta!");
						break;
			}
		
			System.out.println("\n\t\tLungimea vectorului introdus = " + vectorulMeu.getLungime() + " si k= " + k + "\n");
		}while(optMeniu != 5);
		
		System.out.println("\t\tProgram terminat");	
		
	}//end main
	
}//end main









