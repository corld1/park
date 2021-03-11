package engine.process;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import batiment.Attraction;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;

public class BatimentManager {
	private Map map;

	private List<Attraction> attractions = new ArrayList<Attraction>();
	private List<Block> attractionZone = new ArrayList<Block>();
	public BatimentManager(Map map) {
		super();
		this.map = map;
	}

	public void addBatiment(Block position) {
		//if (attraction.getPrixConstruction() < GameConfiguration.ARGENT) {
		int line = position.getLine();
		int column = position.getColumn();

			if (!map.isOnBorder(position)) {				
				for (int i = 0 ; i<GameConfiguration.ATTRACTION_WIDTH;i++) {
					for (int j = 0 ; j<GameConfiguration.ATTRACTION_HEIGHT;j++) {
						if (i!=0||j!=0)
						attractionZone.add(map.getBlock(line + j, column + i));
						else if (i==0&&j==0) {
							Attraction attraction = new Attraction(map.getBlock(line + j, column + i));
							attractions.add(attraction);							}

					}
				}
			}
			//GameConfiguration.ARGENT =-attraction.getPrixConstruction() ;
		}
	//}

	public Attraction getAttraction(Block position) {
		Iterator<Attraction> iterator = attractions.iterator();
		Attraction attraction = null;
		while (iterator.hasNext()) {
			attraction = iterator.next();
			if (position.equals(attraction.getPosition())) {
				break;
			}
		}
		return attraction;
	}

	public Map getMap() {
		return map;
	}

	public List<Attraction> getAttraction() {
		return attractions;
	}

	
	public List<Block> getAttractionZone() {
		return attractionZone;
	}


	public boolean isABatiment(Block position) {
		for (Attraction attraction : attractions) {
			if (attraction.getPosition().equals(position)&&attractionZone.equals(position)) {
				return true;
			}
			
		}
		return false;
	}

}
