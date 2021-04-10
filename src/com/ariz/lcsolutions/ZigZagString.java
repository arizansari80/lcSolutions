package com.ariz.lcsolutions;

import java.util.HashSet;

public class ZigZagString {
	private static int nextIndex(final int cr,final int lastIndex, final int secondLastIndex, final int totalRow, final int incr) {
		if (cr == 0 || cr == totalRow - 1)
			return lastIndex + incr;
		return secondLastIndex + incr;	
	}
	
	public static String zigZagConvert(final String s, final int numRows) {
		if (numRows >= s.length())
			return s;
		if (numRows == 1)
			return s;
		int incr = 2 * (numRows - 1), n = s.length();
		String retVal = "";
		int decr = numRows - 1;
		int index = -1;
		for (int i = 0; i < numRows; i++) {
			int lastIndex = i;
			int secondLastIndex = lastIndex;
			int counter = 0;
			try {
				retVal += s.charAt(lastIndex);
			} catch (StringIndexOutOfBoundsException e) {
				break;
			}
			while (lastIndex < n) {
				if (i == 0 || i == numRows - 1) {
					lastIndex = nextIndex(i,lastIndex,-1,numRows,incr);
					if (lastIndex < n)
						retVal += s.charAt(lastIndex);
					continue;
				}
				if (counter == 0) {
					index = secondLastIndex + (2 * (decr));
					if (index < n)						
						retVal += s.charAt(index);
					secondLastIndex = lastIndex;
					lastIndex = index;
					counter++;
					continue;
				}
				index = nextIndex(i,lastIndex,secondLastIndex,numRows,incr);
				if (index < n)
					retVal += s.charAt(index);
				secondLastIndex = lastIndex;
				lastIndex = index;
				counter++;
			}
			decr--;
		}
		return retVal;
	}
}
