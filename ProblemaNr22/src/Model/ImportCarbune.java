package Model;

public class ImportCarbune {
	
	String numeTara;
	long importLunar = 0;
	double procentImport = 0.0;
	
	/**
	 * @return the procentImport
	 */
	public double getProcentImport() {
		return procentImport;
	}

	/**
	 * @param procentImport the procentImport to set
	 */
	public void setProcentImport(double procentImport) {
		this.procentImport = procentImport;
	}

	public ImportCarbune() {
		// TODO Auto-generated constructor stub
	}
	
	public ImportCarbune(String numeT, long ImportL) {
		this.numeTara = numeT;
		this.importLunar = ImportL;
	}

	
	public String getNumeTara() {
		return numeTara;
	}

	
	public void setNumeTara(String numeTara) {
		this.numeTara = numeTara;
	}

	
	public long getImportLunar() {
		return importLunar;
	}

	
	public void setImportLunar(long importLunar) {
		this.importLunar = importLunar;
	}
	
}
