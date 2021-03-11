package batiment;

import engine.map.Block;

public abstract class Batiment {
	private int prixConstruction;
	private int prixEntretien;
	private Block taille;
	private Block position;

	public Batiment(int prixC, int prixE, Block taille, Block position) {
		super();
		this.prixConstruction = prixC;
		this.prixEntretien = prixE;
		this.taille = taille;
		this.position = position;
	}

	public Batiment(Block position) {
		this.position = position;
	}

	public int getPrixConstruction() {
		return prixConstruction;
	}

	public void setPrixConstruction(int prixConstruction) {
		this.prixConstruction = prixConstruction;
	}

	public int getPrixEntretien() {
		return prixEntretien;
	}

	public void setPrixEntretien(int prixEntretien) {
		this.prixEntretien = prixEntretien;
	}

	public Block getTaille() {
		return taille;
	}

	public void setTaille(Block taille) {
		this.taille = taille;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "[" + position + "]";
	}

	
	
}
