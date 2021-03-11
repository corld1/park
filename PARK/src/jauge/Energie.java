package jauge;

public class Energie {
	
	private int max;
	private int quantite;
	
	public Energie(int max, int quantite) {
		super();
		this.max = max;
		this.quantite = quantite;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
