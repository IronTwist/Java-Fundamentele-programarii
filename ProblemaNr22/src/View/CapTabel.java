package View;

public class CapTabel {
		public static void capTabelAll(){
			String str="\t\t|Nume Tara | Import lunar |";
			String linii = "\t\t===========================";
			System.out.println(linii);
			System.out.println(str);
			System.out.println(linii);
			
		}
		
		public static void capTabelProcentual() {
			String titlu = "\t\t Afisare sortata in functie de %";
			String str="\t\t|Nume Tara | Import lunar | % carbune |";
			String lin="\t\t=======================================";
			
			System.out.println(titlu);
			System.out.println(lin);
			System.out.println(str);
			System.out.println(lin);
		}
}
