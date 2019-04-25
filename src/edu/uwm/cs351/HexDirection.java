package edu.uwm.cs351;


public enum HexDirection {
	NORTHEAST(0, -1),
	EAST(1, 0),
	SOUTHEAST(1, 1),
	SOUTHWEST(0, 1),
	WEST(-1, 0),
	NORTHWEST(-1, -1);

	private final int da, db;
	
	private HexDirection(int a, int b) {
		da = a;
		db = b;
	}
	
	/**
	 * Compute the HexCoordinate if we go in this direction from the 
	 * argument.
	 * 
	 * @param c        HexCoordinate to start at (must not be null)
	 * @return         new HexCoordinate where we end up (not null)
	 */
	public HexCoordinate applyTo(HexCoordinate c) {
		return new HexCoordinate(c.a()+da,c.b()+db);
	}
	
	/**
	 * Compute the direction from the first coordinate to the second.
	 * Return null, if it's not possible to get from the first to the 
	 * second in a single application of a direction.
	 * 
	 * @param c1       first coordinate, must not be null
	 * @param c2       second coordinate, must not be null
	 * @return         HexDirection from c1 to c2, or null, if none 
	 *                 exists.
	 */
	public static HexDirection from(HexCoordinate c1, HexCoordinate c2) {
		if (c2 == null) throw new NullPointerException();
		// easy but inefficient:
		for (HexDirection hd : values()) {
			if (hd.applyTo(c1).equals(c2)) return hd;
		}
		return null;
	}
}
