package gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import batiment.Attraction;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.BatimentManager;
import engine.process.PersonneManager;
import personne.Mascotte;
import personne.Mecanicien;
import personne.Visiteur;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private PersonneManager managerPersonne;
	private BatimentManager managerBatiment;

	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, PersonneManager managerPersonne, BatimentManager managerBatiment) {
		this.map = map;
		this.managerPersonne = managerPersonne;
		this.managerBatiment = managerBatiment;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);
		
		for (Attraction attraction : managerBatiment.getAttraction()) {
			paintStrategy.paint(attraction, g);
		}
		
		List<Block> attractionZone = managerBatiment.getAttractionZone();
		paintStrategy.paint(attractionZone, g);
		
		for (Visiteur visiteur : managerPersonne.getVisiteur()) {
			paintStrategy.paint(visiteur, g);
		}
		for (Mecanicien mecanicien : managerPersonne.getMecanicien()) {
			paintStrategy.paint(mecanicien, g);
		}
		for (Mascotte mascotte : managerPersonne.getMascotte()) {
			paintStrategy.paint(mascotte, g);
		}

	}

	public Block getAttractionPosition(int x, int y) {
		int line = y / GameConfiguration.BLOCK_SIZE;
		int column = x / GameConfiguration.BLOCK_SIZE;
		return map.getBlock(line, column);
	}

}
