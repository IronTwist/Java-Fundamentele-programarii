package Model;

public class Fluviu {
	private String nume;			//date membru(starea clasei)
	private int lungime;
	
	public Fluviu(String nume, int lungime) {
		this.nume = nume;
		this.lungime = lungime;
	}
	
	public String getNume() {		
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getLungime() {
		return lungime;
	}
	public void setLungime(int lungime) {
		if(lungime <= 0)
			this.lungime = 1;
		else
			this.lungime = lungime;
	}
	
	public boolean maiLung(Fluviu f) {
		if(lungime > f.lungime) return true; //ob.maiLung(ob1)
		else 					return false;
	}
	
	public boolean alfabetic(Fluviu f) {		//ob.alfabetic(ob1) -> return true
		int I = nume.compareTo(f.nume);
		if(I == -1){
			return true;
		}else {
			return false;	
		}
	}
	
}


