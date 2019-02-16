package edu.uwm.cs351;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * The status of an imaginary three player game
 * in which pieces are on the board, in reserve and also captured.
 */
public class GameStatus {

	private final HexBoard hexBoard;
	private final Piece.Collection inPlay;
	private final Piece.Collection[] captured;
	private final Piece.Collection[] reserved;
	
	/**
	 * Create an initial game with a given board.
	 * @param b hex board to use, must not be null
	 */
	public GameStatus(HexBoard b) {
		if (b == null) throw new NullPointerException("board cannot be null");
		hexBoard = b;
		inPlay = new Piece.Collection();
		int n = Team.values().length;
		captured = new Piece.Collection[n];
		reserved = new Piece.Collection[n];
	}

	/**
	 * Draw the game in the window.
	 * @param g graphics context to draw in, must not be null
	 */
	public void draw(Graphics g) {
		for (HexTile h : hexBoard) {
			h.draw(g);
		}
		for (Piece p : inPlay) {
			p.draw(g, HexTile.WIDTH);
		}
	}
	
	/**
	 * Write the game status to an output.
	 * @param pw output, must not be null
	 */
	public void write(PrintWriter pw) {
		for (Piece p : inPlay) {
			pw.println(p);
		}
		for (Team t: Team.values()) {
			writeColl(pw,reserved[t.ordinal()],"reserved by " + t);
			writeColl(pw,captured[t.ordinal()],"captured by " + t);
		}
	}
	
	private void writeColl(PrintWriter pw, Collection<Piece> c, String kind) {
		if (!c.isEmpty()) {
			pw.println("// " + kind);
			for (Piece p : c) {
				pw.println(p);
			}
		}
	}
	
	/**
	 * Read in game status from an input source
	 * @param br input, must not be null
	 * @throws IOException if there is an error reading
	 * @throws FormatExeption if there is an error with the contents
	 */
	public void read(BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			if (line.indexOf('<') < 0) break;
			inPlay.add(Piece.fromString(line));
		}
		while (line != null) {
			Team t;
			Piece.Collection coll;
			if (line.startsWith("// reserved by ")) {
				t = Team.valueOf(line.substring("// reserved by ".length()));
				coll = reserved[t.ordinal()];
			} else if (line.startsWith("// captured by")) {
				t = Team.valueOf(line.substring("//capsture by".length()));
				coll = captured[t.ordinal()];
			} else {
				throw new FormatException("Unknown game file line: " + line);
			}
			while ((line = br.readLine()) != null) {
				if (line.indexOf('<') < 0) break;
				coll.add(Piece.fromString(line));
			}
		}
	}
}
