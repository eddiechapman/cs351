import java.applet.Applet;
import java.awt.Graphics;

import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Terrain;

public class Main extends Applet {
	private static final long serialVersionUID = 1L;

	HexTile test1 = new HexTile(Terrain.LAND,new HexCoordinate(1,1));
	HexTile test2 = new HexTile(Terrain.FOREST,new HexCoordinate(2,1));
	HexTile test3 = new HexTile(Terrain.MOUNTAIN,new HexCoordinate(2,2));
	HexTile test4 = new HexTile(Terrain.CITY,new HexCoordinate(1,2));
	HexTile test5 = new HexTile(Terrain.DESERT,new HexCoordinate(3,1));
	HexTile test6 = new HexTile(Terrain.WATER, new HexCoordinate(3,2));
	HexTile test7 = new HexTile(Terrain.INACCESSIBLE,new HexCoordinate(3,3));
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		test1.draw(g);
		test2.draw(g);
		test3.draw(g);
		test4.draw(g);
		test5.draw(g);
		test6.draw(g);
		test7.draw(g);
	}
	
	
}
