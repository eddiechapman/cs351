import java.awt.Color;

import edu.uwm.cs351.Terrain;
import junit.framework.TestCase;


public class TestTerrain extends TestCase {

	public void testA() {
		Terrain t = Terrain.valueOf("INACCESSIBLE");
		assertEquals(Color.BLACK,t.getColor());
	}

	public void testB() {
		Terrain t = Terrain.valueOf("WATER");
		assertEquals(Color.CYAN,t.getColor());
	}

	public void testC() {
		Terrain t = Terrain.valueOf("LAND");
		assertEquals(Color.WHITE,t.getColor());
	}

	public void testD() {
		Terrain t = Terrain.valueOf("FOREST");
		assertEquals(Color.GREEN,t.getColor());
	}

	public void testE() {
		Terrain t = Terrain.valueOf("MOUNTAIN");
		assertEquals(Color.LIGHT_GRAY,t.getColor());
	}

	public void testF() {
		Terrain t = Terrain.valueOf("CITY");
		assertEquals(Color.ORANGE,t.getColor());
	}

	public void testG() {
		Terrain t = Terrain.valueOf("DESERT");
		assertEquals(Color.YELLOW,t.getColor());
	}
}
