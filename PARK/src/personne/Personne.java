package personne;

import engine.map.Block;

public abstract class Personne {
	private Block position;
	private int argent;

	public Personne(Block position) {
		this.position = position;
	}
	
	public Personne(Block position, int argent) {
		this.position = position;
		this.argent = argent;
	}

	public Block getPosition() {
		return position;
	}
	
	public Block getPositionTop() {
		return new Block(position.getLine() - 1, position.getColumn());
	}
	
	public Block getPositionBottom() {
		return new Block(position.getLine() + 1, position.getColumn());
	}
	
	public Block getPositionRight() {
		return new Block(position.getLine(), position.getColumn() + 1);
	}
	
	public Block getPositionLeft() {
		return new Block(position.getLine(), position.getColumn() - 1);
	}

	public void setPosition(Block position) {
		this.position = position;
	}
	
	public void setPositionTop() {
		this.position = new Block(position.getLine() - 1, position.getColumn());
	}
	
	public void setPositionBottom() {
		this.position = new Block(position.getLine() + 1, position.getColumn());
	}
	
	public void setPositionRight() {
		this.position = new Block(position.getLine(), position.getColumn() + 1);
	}
	
	public void setPositionLeft() {
		this.position = new Block(position.getLine(), position.getColumn() - 1);
	}


	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	@Override
	public String toString() {
		return "[" + position + "]";
	}

}
