package edu.uwm.cs.util;

public class BitUtil {

	public BitUtil() {
		// TODO Auto-generated constructor stub
	}

	private static int[] reverseHex = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	
	public static int reverseNybble(int h) {
		return reverseHex[h];
	}
	
	/**
	 * Return a number 0-255 that is the reverse of the bits in the given byte
	 * @param b parameter to reverse
	 * @return reverse of the parameter
	 */
	public static int reverseByte(byte b) {
		return reverseHex[15&(b >> 4)] | (reverseHex[b & 15] << 4);
	}
	
	public static int reverseBits(int n) {
		return reverseByte((byte) (n >> 24)) | 
				(reverseByte((byte) ((n >> 16)&255)) << 8) |
				(reverseByte((byte) ((n >> 8)&255))<<16) | 
				(reverseByte((byte) (n & 255)) << 24);
	}
}
