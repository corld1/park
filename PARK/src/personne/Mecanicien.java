package personne;

import engine.map.Block;

public class Mecanicien extends Employe {
	
	private boolean statut;

	public Mecanicien(Block position) {
		super(position);
	}
	
	public Mecanicien(Block position, int salaire, int niveau, boolean statut) {
		super(position, salaire, niveau);
		this.statut = statut;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
