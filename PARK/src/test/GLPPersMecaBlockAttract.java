package test;

import gui.MainGUI;

public class GLPPersMecaBlockAttract {
	public static void main(String[] args) {

		MainGUI gameMainGUI = new MainGUI("Aircraft game");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
