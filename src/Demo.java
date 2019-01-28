import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.uwm.cs351.FormatException;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.HexTileSeq;
import edu.uwm.cs351.Terrain;

/**
 * Render files of hex tiles on the screen.
 * The main program should be executed with a series of
 * files  Each file is opened in turn and the hex tiles aread from it.
 * If no files are given to the main program, it read hex tiles
 * from standard input.
 */
public class Demo extends JFrame {
	/**
	 * Eclipse wants this
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		final HexTileSeq seq = new HexTileSeq();
		try {
			if (args.length == 0) {
				System.out.println("Enter hex tiles (one on each line) and then type 'quit'.");
				readSeq(seq,new BufferedReader(new InputStreamReader(System.in)));
			} else {
				for (String arg : args) {
					readSeq(seq,new BufferedReader(new FileReader(arg)));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Demo x = new Demo(seq);
				x.setSize(500, 300);
				x.setVisible(true);
				x.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
	}
	
	private static void readSeq(HexTileSeq seq, BufferedReader r) throws IOException {
		String input;
		while ((input = r.readLine()) != null && !input.equalsIgnoreCase("quit")) {
			try {
				// TODO: use fromString to get a hex tile and then add it to the sequence
			} catch (FormatException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Return a hex tile from its string representation.
	 * @param input string of the form TERRAIN<a,b,c>, must not be null
	 * @return hex tile with this string representation
	 */
	protected static HexTile fromString(String input) {
		// XXX: This code is ridiculous:
		// It is left here to allow reading of hex tiles to be left to Homework #3
		switch (input) {
		case "LAND<1,1,0>": 
			return new HexTile(Terrain.LAND,new HexCoordinate(1,1,0));
		case "FOREST<2,1,1>":
			return new HexTile(Terrain.FOREST,new HexCoordinate(2,1,1));
		case "MOUNTAIN<2,2,0>":
			return new HexTile(Terrain.MOUNTAIN,new HexCoordinate(2,2,0));
		case "CITY<1,2,-1>":
			return new HexTile(Terrain.CITY,new HexCoordinate(1,2,-1));
		case "DESERT<3,1,2>":
			return new HexTile(Terrain.DESERT,new HexCoordinate(3,1,2));
		case "WATER<3,2,1>":
			return new HexTile(Terrain.WATER,new HexCoordinate(3,2,1));
		case "INACCESSIBLE<3,3,0>":
			return new HexTile(Terrain.INACCESSIBLE,new HexCoordinate(3,3,0));
		default:
			throw new FormatException("Unable to read hexile from " + input);
		}
	}

	@SuppressWarnings("serial")
	public Demo(final HexTileSeq seq) {
		this.setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// TODO: draw all the hex tiles in the sequence (using HexTile#draw)
				// For this Homework, it's OK to move the cursor.
			}
		});
	}
}
