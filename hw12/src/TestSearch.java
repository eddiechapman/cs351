import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import junit.framework.TestCase;
import edu.uwm.cs351.HexBoard;
import edu.uwm.cs351.HexCoordinate;
import edu.uwm.cs351.HexPath;
import edu.uwm.cs351.HexPathCoster;
import edu.uwm.cs351.HexTile;
import edu.uwm.cs351.Search;
import edu.uwm.cs351.Terrain;
import edu.uwm.cs351.util.FIFOWorklist;
import edu.uwm.cs351.util.LIFOWorklist;
import edu.uwm.cs351.util.PriorityWorklist;


public class TestSearch extends TestCase {

	JFrame f; Panel panel;
	HexCoordinate start, end;
	
	HexBoard b;
	HexPath p;
	HexPathCoster c;
	HexCoordinate[] a;
	
	HexPath fifoPath, lifoPath, priorityPath;
	Search fifoSearch, lifoSearch, prioritySearch;
	
	private HexCoordinate h(int a, int b) {
		return new HexCoordinate(a,b);
	}
	
	private void p(int a, int b, Terrain t) {
		this.b.asMap().put(h(a,b),t);
	}
	
	protected void setUp() {
		b = new HexBoard();
		c = new HexPathCoster(b);
		p(0,0,Terrain.MOUNTAIN);
		p(0,0,Terrain.MOUNTAIN);
		p(1,0,Terrain.MOUNTAIN);
		p(2,0,Terrain.MOUNTAIN);
		p(3,0,Terrain.MOUNTAIN);
		p(4,0,Terrain.MOUNTAIN);
		p(5,0,Terrain.MOUNTAIN);
		p(6,0,Terrain.MOUNTAIN);
		p(1,1,Terrain.FOREST);
		p(3,1,Terrain.FOREST);
		p(4,1,Terrain.FOREST);
		p(6,1,Terrain.FOREST);
		p(2,2,Terrain.LAND);
		p(3,2,Terrain.LAND);
		p(4,2,Terrain.CITY);
		p(5,2,Terrain.LAND);
		p(6,2,Terrain.LAND);
		p(3,3,Terrain.LAND);
		p(4,3,Terrain.WATER);
		p(5,3,Terrain.WATER);
		p(6,3,Terrain.LAND);
		p(4,4,Terrain.DESERT);
		p(5,4,Terrain.WATER);
		p(6,4,Terrain.DESERT);
		p(5,5,Terrain.DESERT);
		p(6,5,Terrain.DESERT);
		p(6,6,Terrain.CITY);
		p(7,6,Terrain.INACCESSIBLE);
		p(8,6,Terrain.LAND);
		p(4,6,Terrain.LAND);
		c.setCost(Terrain.FOREST,2);
		c.setCost(Terrain.CITY,3);
		c.setCost(Terrain.MOUNTAIN,4);
		c.setCost(Terrain.WATER,5);
		
		lifoSearch = new Search(new LIFOWorklist<HexPath>());
		fifoSearch = new Search(new FIFOWorklist<HexPath>());
		prioritySearch = new Search(new PriorityWorklist<HexPath>(c));
	}
	
	private JRadioButtonMenuItem showLIFO, showFIFO, showPrio;
	
	private class Panel extends JPanel implements ActionListener {
		/**
		 * Keep Eclipse Happy
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
			for (HexTile h : b) {
				h.draw(g);
			}
			if (start != null) markTile(g,start, Color.BLUE);
			if (end != null) markTile(g,end, Color.RED);
			
			if (showLIFO.isSelected()) {
				p = lifoPath;
				lifoSearch.markVisited(g);
			}
			if (showFIFO.isSelected()) {
				p = fifoPath;
				fifoSearch.markVisited(g);
			}
			if (showPrio.isSelected()) {
				p = priorityPath;
				prioritySearch.markVisited(g);
			}
			if (p != null) {
				p.draw(g);
			}
		}

		private void markTile(Graphics g, HexCoordinate h, Color c) {
			Point p = h.toPoint(HexTile.WIDTH);
			int rad = HexTile.WIDTH/4;
			g.setColor(c);
			g.fillOval(p.x-rad,p.y-rad,rad*2,rad*2);
		}
		
		public void actionPerformed(ActionEvent arg0) {
			repaint();
		}		
	}
	
	private ActionListener doTest = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem it = (JMenuItem) e.getSource();
			try {
				Method m = TestSearch.class.getMethod(it.getText());
				m.invoke(TestSearch.this);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(f, e1.getLocalizedMessage(), "Internal Error", JOptionPane.ERROR_MESSAGE);
			} catch (junit.framework.AssertionFailedError ex) {
				JOptionPane.showMessageDialog(f, ex.getLocalizedMessage(), "Test Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			panel.repaint();
		}
	};

	public void showResults() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				f = new JFrame("Test Board");
				JMenuBar mb = new JMenuBar();
				f.setJMenuBar(mb);
				panel = new Panel();
				f.getContentPane().add(panel,BorderLayout.CENTER);
				f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);			
				ButtonGroup g = new ButtonGroup();
				showLIFO = new JRadioButtonMenuItem("LIFO"); g.add(showLIFO);
				showFIFO = new JRadioButtonMenuItem("FIFO"); g.add(showFIFO);
				showPrio = new JRadioButtonMenuItem("Priority"); g.add(showPrio);
				showLIFO.addActionListener(panel);
				showFIFO.addActionListener(panel);
				showPrio.addActionListener(panel);
				showLIFO.setSelected(true);
				JMenu viewMenu = new JMenu("View");
				mb.add(viewMenu);
				viewMenu.add(showLIFO);
				viewMenu.add(showFIFO);
				viewMenu.add(showPrio);
				JMenu testMenu = new JMenu("Test");
				mb.add(testMenu);
				g = new ButtonGroup();
				for (int i : TESTS) {
					JRadioButtonMenuItem test = new JRadioButtonMenuItem("test" + i);
					g.add(test);
					test.addActionListener(doTest);
					testMenu.add(test);
				}
				f.setSize(new Dimension(300,400));
				f.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		final TestSearch t = new TestSearch();
		t.setUp();
		t.showResults();
	}
	
	private static final int[] TESTS = {0,1,2,3,6,8,9};
	
	public void test0() {
		start = h(6,6);
		end = h(6,6);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		assertEquals(0,p.size());
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertEquals(0,p.size());
		
		p = priorityPath = prioritySearch.find(start, end, b);
		assertEquals(0,p.size());
	}
	
	public void test1() {
		start = h(6,6);
		end = h(5,5);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		if (p.size() != 13) assertEquals(1,p.size());
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertEquals(1,p.size());

		p = priorityPath = prioritySearch.find(start, end, b);
		assertEquals(1,p.size());
	}

	public void test2() {
		start = h(6,6);
		end = h(6,5);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		if (p.size() != 13) assertEquals(1,p.size());
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertEquals(1,p.size());

		p = priorityPath = prioritySearch.find(start, end, b);
		assertEquals(1,p.size());
	}

	public void test3() {
		start = h(6,6);
		end = h(5,4);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		assertEquals(12,p.size());
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertEquals(2,p.size());
		
		p = priorityPath = prioritySearch.find(start, end, b);
		assertEquals(2,p.size());
	}
	
	public void test6() {
		start = h(6,6);
		end = h(4,2);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		assertEquals(16,p.size());
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertEquals(4,p.size());
		
		p = priorityPath = prioritySearch.find(start, end, b);
		assertEquals(5,p.size());
	}
	
	public void test8() {
		start = h(6,6);
		end = h(8,6);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		assertNull(p);
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertNull(p);
		
		p = priorityPath = prioritySearch.find(start, end, b);
		assertNull(p);
	}
	
	public void test9() {
		start = h(6,6);
		end = h(4,6);
		
		p = lifoPath = lifoSearch.find(start, end, b);
		assertNull(p);
		
		p = fifoPath = fifoSearch.find(start, end, b);
		assertNull(p);
		
		p = priorityPath = prioritySearch.find(start, end, b);
		assertNull(p);
	}
}
