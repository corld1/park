package engine.map;

public class Block {
	private int line;
	private int column;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Block other = (Block) obj;
		if (column != other.column)
			return false;
		
		if (line != other.line)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "[" + line + ", " + column + "]";
	}

}
