package batiment;

import engine.map.Block;

public class Attraction extends Batiment {
	private int bonheur;
	private int duree;
	private int attractivite;
	private String categorie;
	private int tempsConstruction;
	private boolean status;
	private int niveau;
	private Etat etat;
	
	public Attraction(Block position) {
		super(position);
	}
	public Attraction(Block position, boolean status) {
		super(position);
		this.status = status;
	}
	public Attraction(int prixC, int prixE, Block taille, Block position, int bonheur, int duree, int attractivite,
			String categorie, int tempsConstruction, boolean status, int niveau, Etat etat) {
		super(prixC, prixE, taille, position);
		this.bonheur = bonheur;
		this.duree = duree;
		this.attractivite = attractivite;
		this.categorie = categorie;
		this.tempsConstruction = tempsConstruction;
		this.status = status;
		this.niveau = niveau;
		this.etat = etat;
	}
	public int getBonheur() {
		return bonheur;
	}
	public void setBonheur(int bonheur) {
		this.bonheur = bonheur;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getAttractivite() {
		return attractivite;
	}
	public void setAttractivite(int attractivite) {
		this.attractivite = attractivite;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getTempsConstruction() {
		return tempsConstruction;
	}
	public void setTempsConstruction(int tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
