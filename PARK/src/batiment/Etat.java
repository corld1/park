package batiment;

public class Etat {
	private int etatActuel;
	private int etatMax;
	
	public int getEtatActuel() {
		return etatActuel;
	}
	public void setEtatActuel(int etatActuel) {
		this.etatActuel = etatActuel;
	}
	public int getEtatMax() {
		return etatMax;
	}
	public void setEtatMax(int etatMax) {
		this.etatMax = etatMax;
	}
	
	@Override
	public String toString() {
		return "Etat [etatActuel=" + etatActuel + ", etatMax=" + etatMax + "]";
	}
	
	
	
	
}
