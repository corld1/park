package batiment;

import engine.map.Block;

public class Magasin extends Attraction {
	private int energie;
	private int argent;
	
	public Magasin(int prixC, int prixE, Block taille, Block position, int bonheur, int duree, int attractivite,
			String categorie, int tempsConstruction, boolean status, int niveau, Etat etat, int energie, int argent) {
		super(prixC, prixE, taille, position, bonheur, duree, attractivite, categorie, tempsConstruction, status,
				niveau, etat);
		this.energie = energie;
		this.argent = argent;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

}
