package personne;

import engine.map.Block;

public class Mascotte extends Employe {
	
	private int energie;

	public Mascotte(Block position) {
		super(position);
	}
	
	public Mascotte(Block position, int salaire, int niveau, int energie) {
		super(position, salaire, niveau);
		this.energie = energie;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	@Override
	public String toString() {
		return "Mascotte [energie=" + energie + "]";
	}

}
