package engine.map;

public class Map {
	private Block[][] blocks;

	private int lineCount;
	private int columnCount;

	public Map(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public boolean isOnTopBorder(Block block) {
		int line = block.getLine();
		return line == 0;
	}

	public boolean isOnBottomBorder(Block block) {
		int line = block.getLine();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getColumn();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getColumn();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTopBorder(block) || isOnBottomBorder(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}

}
