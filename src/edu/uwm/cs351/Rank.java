package edu.uwm.cs351;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import edu.uwm.cs351.util.ColoredIcon;

/**
 * Rank of a piece in a hypothetical game.
 * <div>Icons made by <a href="https://www.freepik.com/" title="Freepik">Freepik</a> 
 * from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> 
 * is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">
 * CC 3.0 BY</a></div>.
 * <div>Icon made from 
 * <a href="http://www.onlinewebfonts.com/icon">Icon Fonts</a> 
 * is licensed by CC BY 3.0</div>.
 * Also, one icon by <a href="https://visualpharm.com/free-icons/tank-595b40b85ba036ed117dbbef
">Visual Pharm</a>
 */
public enum Rank {
	BOAT("boat"), 
	FOOT("relaxing-walk"), 
	HORSE("quiet-horse-side-view-silhouette"), 
	CAR("car-compact"), 
	TANK("tank");
	
	private final Icon small, medium;
	
	private Rank(String name) {
		small = new ImageIcon("lib" + File.separator + name + ".png");
		medium = new ImageIcon("lib" + File.separator + name + "-2.png");
	}
	
	/**
	 * Return the relative power of this rank,
	 * with {@link #BOAT} being lowest and {@link #TANK} being highest.
	 * @return integer power of the rank.
	 */
	public int power() {
		return this.ordinal();
	}
	
	private static Icon[][][] allIcons;
	static {
		allIcons = new Icon[Rank.values().length][Team.values().length][2];
	}
	
	private static Icon getIcon(Rank r, Team t, int step) {
		int ri = r.ordinal();
		int ti = t.ordinal();
		Icon result = allIcons[ri][ti][step];
		if (result == null) {
			Icon base = step == 0 ? r.small : r.medium;
			allIcons[ri][ti][step] = result = ColoredIcon.color(base, t.getColor());
		}
		return result;
	}

	private static final int MEDIUM_SIZE = 32;
	
	/**
	 * Get an icon for the rank that (hopefully) will fit in the given
	 * number of pixels.  Currently there are only two sizes: 16 and 32.
	 * @param size number of pixels.
	 * @return icon of required size.
	 */
	public Icon getIcon(Team t, int size) {
		int step = 0;
		if (size >= MEDIUM_SIZE) step = 1;
		return getIcon(this,t,step);
	}
}
