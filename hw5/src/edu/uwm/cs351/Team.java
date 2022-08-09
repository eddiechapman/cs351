package edu.uwm.cs351;

import java.awt.Color;

/**
 * A team in a multi-player game.
 */
public enum Team {
	RED(Color.RED), GREEN(Color.decode("#006400")), BLUE(Color.BLUE);
	
	private final Color color;
	private Team(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
}
