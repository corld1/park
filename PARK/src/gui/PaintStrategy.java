package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import batiment.Attraction;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import personne.Mascotte;
import personne.Mecanicien;
import personne.Visiteur;

public class PaintStrategy {
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(Color.LIGHT_GRAY);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}

				// billetterie
				graphics.setColor(Color.GREEN);
				graphics.drawRect(0, 0, blockSize * 4, blockSize * 2);
				graphics.fillRect(0, 0, blockSize * 4, blockSize * 2);

				// attraction 1
//				graphics.setColor(Color.ORANGE);
//				graphics.drawRect(blockSize, blockSize * 5, blockSize * 4, blockSize * 3);
//				graphics.fillRect(blockSize, blockSize * 5, blockSize * 4, blockSize * 3);
//				// attraction 2
//				graphics.setColor(Color.ORANGE);
//				graphics.drawRect(blockSize * 6, blockSize * 6, blockSize * 4, blockSize * 3);
//				graphics.fillRect(blockSize * 6, blockSize * 6, blockSize * 4, blockSize * 3);
//				// attraction 3
//				graphics.setColor(Color.ORANGE);
//				graphics.drawRect(blockSize * 11, blockSize * 6, blockSize * 4, blockSize * 3);
//				graphics.fillRect(blockSize * 11, blockSize * 6, blockSize * 4, blockSize * 3);
//				// attraction 3
//				graphics.setColor(Color.ORANGE);
//				graphics.drawRect(blockSize * 15, blockSize * 1, blockSize * 4, blockSize * 3);
//				graphics.fillRect(blockSize * 15, blockSize * 1, blockSize * 4, blockSize * 3);

				// magasin 1
//				graphics.setColor(Color.YELLOW);
//				graphics.drawRect(blockSize * 6, blockSize, blockSize * 3, blockSize * 3);
//				graphics.fillRect(blockSize * 6, blockSize, blockSize * 3, blockSize * 3);
//				// magasin 2
//				graphics.setColor(Color.YELLOW);
//				graphics.drawRect(blockSize * 11, blockSize, blockSize * 3, blockSize * 3);
//				graphics.fillRect(blockSize * 11, blockSize, blockSize * 3, blockSize * 3);
//				// magasin 3
//				graphics.setColor(Color.YELLOW);
//				graphics.drawRect(blockSize * 16, blockSize * 6, blockSize * 3, blockSize * 3);
//				graphics.fillRect(blockSize * 16, blockSize * 6, blockSize * 3, blockSize * 3);
			}
		}
	}

	public void paint(Visiteur visiteur, Graphics graphics) {
		Block position = visiteur.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.BLUE);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	public void paint(Mascotte mascotte, Graphics graphics) {
		Block position = mascotte.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.CYAN);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		graphics.drawRect((x * blockSize) - (blockSize * 1 / 2), (y * blockSize) - (blockSize * 1 / 2), blockSize * 2,
				blockSize * 2);
//		graphics.drawRect(x * blockSize, y * blockSize, blockSize * 2, blockSize * 2);
	}

	public void paint(Mecanicien mecanicien, Graphics graphics) {
		Block position = mecanicien.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.GRAY);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	public void paint(Attraction attraction, Graphics graphics) {
		Block position = attraction.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int x = position.getColumn();
		int y = position.getLine();

		graphics.setColor(Color.BLACK);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	public void paint(List<Block> attractionZone, Graphics graphics) {
		for (Block block : attractionZone) {

			int blockSize = GameConfiguration.BLOCK_SIZE;

			int x = block.getColumn();
			int y = block.getLine();

			graphics.setColor(Color.ORANGE);
			graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		}
	}
}
