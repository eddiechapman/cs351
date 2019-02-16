package edu.uwm.cs351;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HexBoardEditor extends JFrame {
	/**
	 * Eclipse wants this
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		final HexBoard seq = new HexBoard();
		try {
			for (String arg : args) {
				seq.read(new BufferedReader(new FileReader(arg)));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Errror reading HexBoard", JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final HexBoardEditor x = new HexBoardEditor(seq);
				x.setSize(800, 500);
				x.setVisible(true);
				// indicate that we don't want automatic close:
				x.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				// if someone closes the window, then we print out all the hex tiles and then
				// dispose the window
				x.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {
						// #(
						for (HexTile h : seq) {
							System.out.println(h);
						}
						// #)
						// TODO: print out all tiles in the picture to standard output
						x.setVisible(false);
						x.dispose();
					}
					
				});
			}
		});
	}
		
	private final HexBoard board;
	private HexCoordinate selected  = new HexCoordinate(0,0,0);
	private Terrain currentTerrain = Terrain.INACCESSIBLE;
	private JComboBox<Integer> sizeSelector = new JComboBox<>(new Integer[]{10,15,20,30,50,75,100,150,200,500});
	private JComponent terrainIndicator = new TerrainIndicator();
	
	/**
	 * Return the currently selected hexagon width
	 * @return current hexagon width
	 */
	protected int getHexWidth() {
		return ((Integer)sizeSelector.getSelectedItem()).intValue();
	}

	public HexBoardEditor(final HexBoard seq) {
		board = seq;
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		final HexPanel hexPanel = new HexPanel();
		contentPane.add(hexPanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		// #(
		for (final Terrain t : Terrain.values()) {
			JButton b = new JButton(t.name());
			b.setOpaque(true);
			b.setBackground(t.getColor());
			b.addActionListener(new ActionListener() {
				// @Override
				public void actionPerformed(ActionEvent e) {
					currentTerrain = t;
					terrainIndicator.repaint();
				}
			});
			buttonPanel.add(b);
		}
		// #)
		// TODO: Add buttons (use JButton) to the buttonPanel for each kind of terrain's name,
		// setting background color and making opaque, and then activate them
		// by adding an action listener to set the current terrain and make
		// sure the indicator repaints.
		JPanel indicatorPanel = new JPanel();
		sizeSelector.setSelectedItem(HexTile.WIDTH);
		sizeSelector.addActionListener((ae) -> { hexPanel.repaint(); }); // lambda syntax is SHORT!
		indicatorPanel.add(new JLabel("Current Terrain:"));
		indicatorPanel.add(terrainIndicator);
		indicatorPanel.add(new JLabel("  Hexagon Width:"));
		indicatorPanel.add(sizeSelector);
		contentPane.add(indicatorPanel,BorderLayout.NORTH);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
		this.setContentPane(contentPane);
		// #(
		hexPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleClick(e);
				hexPanel.repaint();
			}	
		});
		// #)
		// TODO: if the hex panel is single clicked, 
		// select the location (so it gets highlighted).
		// Use getHexWidth() as the width of hex tiles.
		//
		// If a double click, then if there is no tile there already, 
		// a new tile of the currently selected terrain should be created there.
		// If the current terrain is INACCESSIBLE then delete any existing tile.
		// Otherwise, replace any existing tile with a new tile of the current terrain.
		//
		// Thus INACCESSIBLE is normally an eraser; 
		// but if you double click in an empty area, 
		// then it WILL create an INACCESSIBLE tile.  
		//
		// Afterwards, in any case, tell the hex panel that
		// it needs to be repainted.
	}		
	// #(
	
	/**
	 * Handled a mouse click in the main (hex board) panel.
	 * @param e
	 */
	protected void handleClick(MouseEvent e) {
		if (e.getClickCount() == 1) {
			selected = HexCoordinate.fromPoint(e.getPoint(), getHexWidth());
		} else {
			Terrain t = board.terrainAt(selected);
			if (t != null && currentTerrain == Terrain.INACCESSIBLE) {
				board.remove(new HexTile(t,selected));
			} else {
				board.add(new HexTile(currentTerrain,selected));
			}
		}
	}
	// #)

	private final class HexPanel extends JPanel {
		/**
		 * Keep Eclipse happy
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // render background
			int width = getHexWidth();
			// #(
			for (HexTile h : board) {
				h.draw(g,width);
			}
			g.setColor(Color.MAGENTA);
			g.drawPolygon(selected.toPolygon(width));
			// #)
			// TODO: render all tiles and outline selected area with magenta.
			// Use "width" as the width of the hex tiles.
		}
	}
	
	private class TerrainIndicator extends JLabel {
		/**
		 * Keep Eclipse happy
		 */
		private static final long serialVersionUID = 1L;

		public TerrainIndicator() {
			super("INACCESSIBLE");
			this.setOpaque(true); // need this on some systems to activate color
			this.setBackground(Color.BLACK);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		@Override
		public void repaint() {
			// #(
			setBackground(currentTerrain.getColor());
			setText(currentTerrain.name());
			// #)
			// TODO: set text and background color
			super.repaint();
		}
	}
}
