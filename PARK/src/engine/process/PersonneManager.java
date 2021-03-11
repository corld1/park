package engine.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import personne.Employe;
import personne.Mascotte;
import personne.Mecanicien;
import personne.Visiteur;

public class PersonneManager {
	private Map map;

	private List<Visiteur> visiteurs = new ArrayList<Visiteur>();
	private List<Mecanicien> mecaniciens = new ArrayList<Mecanicien>();
	private List<Mascotte> mascottes = new ArrayList<Mascotte>();
	private List<Employe> employes = new ArrayList<Employe>();

	private int mecanicienDelay = GameConfiguration.MECANICIEN_DELAY;
	private int mecanicienCount = 0;
	
	private BatimentManager managerBatiment = new BatimentManager(map);

	public PersonneManager(Map map) {
		this.map = map;
	}

	public void add(Visiteur visiteur) {
		visiteurs.add(visiteur);
	}

	public void add(Mecanicien mecanicien) {
		mecaniciens.add(mecanicien);
	}

	public void add(Mascotte mascotte) {
		mascottes.add(mascotte);
	}

	public void add(Employe employe) {
		employes.add(employe);
	}

	public void nextRound() {
		generateVisiteur();
		moveVisiteur();

		moveMecanicien();
//		repareAttraction();

		generateMascotte();
		moveMascotte();
	}

	private void generateVisiteur() {
		if (new Random().nextBoolean()) {
//			generate argent
			add(new Visiteur(new Block(1, 2)));
		}
	}

	public void generateMecanicien() {
		if (mecaniciens.size() == 0) {
			add(new Mecanicien(new Block(0, 0)));
//			salaire
			mecanicienCount++;
		}
	}

	private void generateMascotte() {
		if (mascottes.size() == 0) {
			add(new Mascotte(new Block(0, 1)));
//			salaire
		}
	}

//	add employes

	private void moveVisiteur() {
		List<Visiteur> outOfBoundVisiteurs = new ArrayList<Visiteur>();

		for (Visiteur visiteur : visiteurs) {
			Block position = visiteur.getPosition();

			if (!map.isOnBottomBorder(position)) {
				if (Math.random() > 0.2) {
					// deplacement right
					if (Math.random() > 0.8) {
						// deplacement top
						if ((!map.isOnTopBorder(position) && !map.isOnRightBorder(position))
								&& checkMove(map.getBlock(position.getLine() - 1, position.getColumn() + 1))) {
							visiteur.setPosition(map.getBlock(position.getLine() - 1, position.getColumn() + 1));
						} else {
							continue;
						}
					} else {
						// deplacement bottom
						if ((!map.isOnBottomBorder(position) && !map.isOnRightBorder(position))
								&& checkMove(map.getBlock(position.getLine() + 1, position.getColumn() + 1))) {
							visiteur.setPosition(map.getBlock(position.getLine() + 1, position.getColumn() + 1));
						} else {
							continue;
						}
					}
				} else {
					// deplacement left
					if (Math.random() > 0.4) {
						// deplacement bottom
						if ((!map.isOnBottomBorder(position) && !map.isOnLeftBorder(position))
								&& checkMove(map.getBlock(position.getLine() + 1, position.getColumn() - 1))) {
							visiteur.setPosition(map.getBlock(position.getLine() + 1, position.getColumn() - 1));
						} else {
							continue;
						}
					} else {
						// deplacement top
						if ((!map.isOnTopBorder(position) && !map.isOnLeftBorder(position))
								&& checkMove(map.getBlock(position.getLine() - 1, position.getColumn() - 1))) {
							visiteur.setPosition(map.getBlock(position.getLine() - 1, position.getColumn() - 1));
						} else {
							continue;
						}
					}
				}
			} else {
				outOfBoundVisiteurs.add(visiteur);
			}
		}

		for (Visiteur visiteur : outOfBoundVisiteurs) {
			visiteurs.remove(visiteur);
		}
	}

	private void moveMecanicien() {
		List<Mecanicien> outOfBoundMecaniciens = new ArrayList<Mecanicien>();

		for (Mecanicien mecanicien : mecaniciens) {
			Block position = mecanicien.getPosition();

			if (mecanicien.getPosition().getLine() == 0 && mecanicien.getPosition().getColumn() == 1) {
				outOfBoundMecaniciens.add(mecanicien);
			} else if (!map.isOnBottomBorder(position) && map.isOnLeftBorder(position) 
					&& (!managerBatiment.isABatiment(mecanicien.getPositionRight())
					|| managerBatiment.getAttraction(mecanicien.getPositionRight()).isStatus())) {
				mecanicien.setPositionBottom();
			} else if (map.isOnBottomBorder(position) && !map.isOnRightBorder(position) 
					&& (!managerBatiment.isABatiment(mecanicien.getPositionTop())
					|| managerBatiment.getAttraction(mecanicien.getPositionTop()).isStatus())) {
				mecanicien.setPositionRight();
			} else if (!map.isOnTopBorder(position) && map.isOnRightBorder(position) 
					&& (!managerBatiment.isABatiment(mecanicien.getPositionLeft())
					|| managerBatiment.getAttraction(mecanicien.getPositionLeft()).isStatus())) {
				mecanicien.setPositionTop();
			} else if (map.isOnTopBorder(position) && !map.isOnLeftBorder(position) 
					&& (!managerBatiment.isABatiment(mecanicien.getPositionBottom())
					|| managerBatiment.getAttraction(mecanicien.getPositionBottom()).isStatus())) {
				mecanicien.setPositionLeft();
				System.out.println("cc");
			} else if (((managerBatiment.isABatiment(mecanicien.getPositionLeft()))
					|| (managerBatiment.isABatiment(mecanicien.getPositionTop()))
					|| (managerBatiment.isABatiment(mecanicien.getPositionRight()))
					|| (managerBatiment.isABatiment(mecanicien.getPositionBottom()))
							&& mecanicienDelay == 0) && mecanicienCount > 0) {
				if (mecanicienDelay == 0) {
					mecanicienCount--;
					mecanicienDelay = GameConfiguration.MECANICIEN_DELAY;
					if (managerBatiment.isABatiment(mecanicien.getPositionLeft())) {
						managerBatiment.getAttraction(mecanicien.getPositionLeft()).setStatus(true);
					} else if (managerBatiment.isABatiment(mecanicien.getPositionTop())) {
						managerBatiment.getAttraction(mecanicien.getPositionTop()).setStatus(true);
					} else if (managerBatiment.isABatiment(mecanicien.getPositionRight())) {
						managerBatiment.getAttraction(mecanicien.getPositionRight()).setStatus(true);
					} else if (managerBatiment.isABatiment(mecanicien.getPositionBottom())) {
						managerBatiment.getAttraction(mecanicien.getPositionBottom()).setStatus(true);
					}
					System.out.println("reparation achevée");
				} else {
					mecanicienDelay--;
					System.out.println("reparation en cours");
				}
			} else if (!map.isOnBottomBorder(position) && map.isOnLeftBorder(position) 
					|| managerBatiment.getAttraction(mecanicien.getPositionRight()).isStatus()) {
				mecanicien.setPositionBottom();
			} else if (map.isOnBottomBorder(position) && !map.isOnRightBorder(position) 
					|| managerBatiment.getAttraction(mecanicien.getPositionTop()).isStatus()) {
				mecanicien.setPositionRight();
			} else if (!map.isOnTopBorder(position) && map.isOnRightBorder(position) 
					|| managerBatiment.getAttraction(mecanicien.getPositionLeft()).isStatus()) {
				mecanicien.setPositionTop();
			} else if (map.isOnTopBorder(position) && !map.isOnLeftBorder(position) 
					|| managerBatiment.getAttraction(mecanicien.getPositionBottom()).isStatus()) {
				mecanicien.setPositionLeft();
			}
		}

		for (Mecanicien mecanicien : outOfBoundMecaniciens) {
			mecaniciens.remove(mecanicien);
		}
	}

	private void moveMascotte() {
		for (Mascotte mascotte : mascottes) {
			int line = getRandomNumber(0, map.getLineCount() - 1);
			int column = getRandomNumber(0, map.getColumnCount() - 1);
			Block newPosition = new Block(line, column);
			if (checkMove(newPosition)) {
				mascotte.setPosition(newPosition);
			} else {
				continue;
			}
			
		}
	}

//	public void repareAttraction(Attraction attraction) {
//		if (repareAttraction.size() > 0) {
//			List<Mecanicien> outOfBoundMecaniciens = new ArrayList<Mecanicien>();
//			List<Block> zoneAttraction = managerBatiment.zoneAttraction(repareAttraction.get(0).getPosition());
//
//			// Iterator<Mecanicien> iterator = mecaniciens.iterator();
//			// while (iterator.hasNext()) {
//			for (Mecanicien mecanicien : mecaniciens) {
//				for (Block zone : zoneAttraction) {
//					// Mecanicien mecanicien = iterator.next();
//					System.out.println(mecanicien.toString());
//					if (mecanicien.getPositionLeft().equals(zone)) {
//						mecanicien.setPositionLeft();
//					} else if (mecanicien.getPositionTop().equals(zone)) {
//						mecanicien.setPositionTop();
//					} else if (mecanicien.getPositionRight().equals(zone)) {
//						mecanicien.setPositionRight();
//					} else if (mecanicien.getPositionBottom().equals(zone)) {
//						mecanicien.setPositionBottom();
//					}
//				}
//				outOfBoundMecaniciens.add(mecanicien);
//				mecaniciens.remove(mecanicien);
//
//				if (mecanicienDelay == 0) {
//					mecanicienDelay = GameConfiguration.MECANICIEN_DELAY;
//				} else {
//					mecanicienDelay--;
//				}
//
//				for (Mecanicien mecanicienDelete : outOfBoundMecaniciens) {
//					mecaniciens.add(mecanicienDelete);
//					mecaniciens.remove(mecanicienDelete);
//				}
//
//				if (managerBatiment.isABatiment(mecanicien.getPosition())) {
//					if (!managerBatiment.isABatiment(mecanicien.getPositionLeft())) {
//						mecanicien.setPositionLeft();
//					} else if (!managerBatiment.isABatiment(mecanicien.getPositionTop())) {
//						mecanicien.setPositionTop();
//					} else if (!managerBatiment.isABatiment(mecanicien.getPositionRight())) {
//						mecanicien.setPositionRight();
//					} else if (!managerBatiment.isABatiment(mecanicien.getPositionBottom())) {
//						mecanicien.setPositionBottom();
//					}
//				}
//			}
//		}
//	}

	private boolean checkMove(Block newPosition) {
		if (managerBatiment.isABatiment(newPosition)) {
			return false;
		} else {
			return true;
		}
	}

	public List<Visiteur> getVisiteur() {
		return visiteurs;
	}

	public List<Mascotte> getMascotte() {
		return mascottes;
	}

	public List<Mecanicien> getMecanicien() {
		return mecaniciens;
	}

	public List<Employe> getEmploye() {
		return employes;
	}

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

}
