package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.BatimentManager;
import engine.process.GameBuilder;
import engine.process.PersonneManager;
import timer.Chronometer;
import timer.CyclicCounter;
import timer.CyclicCounterFaster;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;

	int x = 0;
	int y = 0;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH,
			GameConfiguration.WINDOW_HEIGHT);

	private PersonneManager managerPersonne;
	private BatimentManager managerBatiment;
	private Chronometer chronometer = new Chronometer();
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");
	private GameDisplay dashboard;

	JLabel argent = new JLabel("nbARGENT");
	JLabel visiteur = new JLabel("nbVISITEUR");
	JLabel note = new JLabel("NOTE");
	JPanel heure = new JPanel();

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {
		
		updateValues();
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		this.add(top(), BorderLayout.NORTH);
		this.add(aside(), BorderLayout.EAST);
		this.add(bottom(), BorderLayout.SOUTH);

		map = GameBuilder.buildMap();
		managerPersonne = GameBuilder.buildInitPersonne(map);
		managerBatiment = GameBuilder.buildInitBatiment(map);
		dashboard = new GameDisplay(map, managerPersonne, managerBatiment);

		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " ");

		CyclicCounterFaster second = chronometer.getSecond();
		secondValue.setText(second.toString() + " ");

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			updateValues();
			managerPersonne.nextRound();
			dashboard.repaint();
		}
	}

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();

			Block batimentPosition = dashboard.getAttractionPosition(x, y);
			if (!managerBatiment.isABatiment(batimentPosition)) {
				if (!map.isOnBorder(batimentPosition)) {
				managerBatiment.addBatiment(batimentPosition);
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	private JPanel top() {
		JPanel top = new JPanel();
		top.setBackground(Color.RED);
		top.setPreferredSize(new Dimension(800, 50));
		top.setLayout(new FlowLayout());
		JLabel label = new JLabel("argent :");
		top.add(label);
		top.add(argent);
		top.add(new JSeparator(SwingConstants.VERTICAL));
		label = new JLabel("visiteur :");
		top.add(label);
		top.add(visiteur);
		top.add(new JSeparator(SwingConstants.VERTICAL));
		label = new JLabel("note :");
		top.add(label);
		top.add(note);
		top.add(new JSeparator(SwingConstants.VERTICAL));
		top.add(heure);
		heure.add(hourValue);
		heure.add(minuteValue);
		heure.add(secondValue);
		top.add(new JSeparator(SwingConstants.VERTICAL));
		JButton btn = new JButton("menu");
		top.add(btn);
		return top;
	}

	private JPanel bottom() {
		JPanel bottom = new JPanel();
		bottom.setBackground(Color.BLUE);
		bottom.setPreferredSize(new Dimension(800, 50));
		bottom.setLayout(new FlowLayout());
		JButton btn = new JButton("attraction");
		bottom.add(btn);
		btn = new JButton("magasin");
		bottom.add(btn);
		btn = new JButton("chemin");
		bottom.add(btn);
		btn = new JButton("employé");
		bottom.add(btn);
		btn = new JButton("succès");
		bottom.add(btn);
		btn = new JButton("reparation");
		btn.addActionListener(new RepareAttraction());
		bottom.add(btn);
		return bottom;
	}

	private class RepareAttraction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			managerPersonne.generateMecanicien();
		}

	}

	private JPanel aside() {
		JPanel aside = new JPanel();
		aside.setBackground(Color.YELLOW);
		aside.setPreferredSize(new Dimension(200, 400));
		return aside;
	}

}
