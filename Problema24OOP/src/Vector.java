import java.util.Scanner;

public class Vector {
	private	int lungime = 0;
	private	int[] vector = null;
	
	public Vector(int lun) {
		this.vector = new int[lun];
	}
	
	public Vector(int lungime, int[] vector) {
		super();
		this.lungime = lungime;
		this.vector = vector;
	}

	public Vector() {
		this.vector = new int[0];
	}

	public int getLungime() {
		return lungime;
	}

	public void setLungime(int lungime) {
		this.lungime = lungime;
	}

	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}
	
	public void populareVector() {														//Scriere vector 
		
		int[] v = new int[this.lungime];
		try {
			Scanner scan = new Scanner(System.in);
			
			for(int i = 0; i < this.lungime; i++) {										
				System.out.print("\t\tIntrodu numar pentru pozitia " + (i + 1) + ": ");
				int numar = scan.nextInt();
				v[i] = numar;
			}
			
			this.vector = v;
		}catch(Exception e){
			System.out.println("A aparut o eroare!");
		}
	}//end populare vector
	
	public void afisareVector() {														//Afisare vector
		for(int i = 0; i < this.lungime-1; i++) {	
			System.out.print(this.vector[i] + ", ");
		}
	}//end afisareVector
	
}
