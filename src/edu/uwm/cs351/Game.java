package edu.uwm.cs351;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JFrame {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 1L;
	
	private final GameStatus status;
	
	public Game(GameStatus st) {
		super("Hex Game");
		status = st;
		
		setContentPane(new HexPanel());
	}
	
	private class HexPanel extends JPanel {
		/**
		 * KEH
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g){
			status.draw(g);
		}
	}
	
	public static void main(String[] args) {
		HexBoard hb = new HexBoard();
		GameStatus status = new GameStatus(hb);
		try {
			if (args.length > 0) {
				hb.read(new BufferedReader(new FileReader(args[0])));
				if (args.length > 1) {
					status.read(new BufferedReader(new FileReader(args[1])));				
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Errror reading HexBoard", JOptionPane.ERROR_MESSAGE);
		}
		SwingUtilities.invokeLater(() -> {
			JFrame f = new Game(status);
			f.setSize(700, 400);
			f.setVisible(true);
			f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		});
	}
}
