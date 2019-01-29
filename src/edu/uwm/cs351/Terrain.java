package edu.uwm.cs351;

import java.awt.Color;

/**
 * A type of terrain depicted on a map using certain colors.
 * 
 * @author eddie
 */
public enum Terrain {
    INACCESSIBLE    (Color.BLACK),
    WATER           (Color.CYAN),
    LAND            (Color.WHITE),
    FOREST          (Color.GREEN),
    MOUNTAIN        (Color.LIGHT_GRAY),
    CITY            (Color.ORANGE),
    DESERT          (Color.YELLOW);
    
    private final Color color;
    
    Terrain(Color color) {
      this.color = color;
    }
    
    public Color getColor() {
      return color;
    }
}