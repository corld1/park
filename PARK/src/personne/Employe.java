package personne;

import engine.map.Block;

public abstract class Employe extends Personne {
	
	private int niveau;
		
	public Employe(Block position) {
		super(position);
	}
	
	public Employe(Block position, int salaire, int niveau) {
		super(position, salaire);
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
