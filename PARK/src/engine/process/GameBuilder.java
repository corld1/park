package engine.process;

import config.GameConfiguration;
import engine.map.Map;

public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static PersonneManager buildInitPersonne(Map map) {
		PersonneManager manager = new PersonneManager(map);

		return manager;
	}

	public static BatimentManager buildInitBatiment(Map map) {
		BatimentManager manager = new BatimentManager(map);

		return manager;
	}

}
