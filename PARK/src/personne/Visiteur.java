package personne;

import engine.map.Block;
import jauge.Bonheur;
import jauge.Energie;

public class Visiteur extends Personne {
	
	private Bonheur bonheur;
	private Energie energie;
	
	public Visiteur(Block position) {
		super(position);
	}
	
	public Visiteur(Block position, int argent, Bonheur bonheur, Energie energie) {
		super(position, argent);
		this.bonheur = bonheur;
		this.energie = energie;
	}

	public Bonheur getBonheur() {
		return bonheur;
	}

	public void setBonheur(Bonheur bonheur) {
		this.bonheur = bonheur;
	}

	public Energie getEnergie() {
		return energie;
	}

	public void setEnergie(Energie energie) {
		this.energie = energie;
	}

	@Override
	public String toString() {
		return "Visiteur [bonheur=" + bonheur + ", energie=" + energie + "]";
	}
	
}
