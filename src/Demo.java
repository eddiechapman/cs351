import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
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

	HexTile test1 = new HexTile(Terrain.LAND,new HexCoordinate(1,1));
	HexTile test2 = new HexTile(Terrain.FOREST,new HexCoordinate(2,1));
	HexTile test3 = new HexTile(Terrain.MOUNTAIN,new HexCoordinate(2,2));
	HexTile test4 = new HexTile(Terrain.CITY,new HexCoordinate(1,2));
	HexTile test5 = new HexTile(Terrain.DESERT,new HexCoordinate(3,1));
	HexTile test6 = new HexTile(Terrain.WATER, new HexCoordinate(3,2));
	HexTile test7 = new HexTile(Terrain.INACCESSIBLE,new HexCoordinate(3,3));

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Demo x = new Demo();
				x.setSize(500, 300);
				x.setVisible(true);
				x.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
	}

	@SuppressWarnings("serial")
	public Demo() {
		this.setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				test1.draw(g);
				test2.draw(g);
				test3.draw(g);
				test4.draw(g);
				test5.draw(g);
				test6.draw(g);
				test7.draw(g);
			}
		});
	}
}
