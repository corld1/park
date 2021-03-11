package batiment;

import engine.map.Block;

public class Billeterie extends Batiment {
	private int argent;

	public Billeterie(int prixC, int prixE, Block taille, Block position, int argent) {
		super(prixC, prixE, taille, position);
		this.argent = argent;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}
	
}
