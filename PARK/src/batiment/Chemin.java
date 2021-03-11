package batiment;

import engine.map.Block;

public abstract class Chemin extends Batiment {
	private int limite;

	public Chemin(int prixC, int prixE, Block taille, Block position, int limite) {
		super(prixC, prixE, taille, position);
		this.limite = limite;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}
	
}
