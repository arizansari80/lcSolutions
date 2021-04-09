package com.ariz.lcsolutions;

public class ZigZagString {
	public static String zigZagConvert(final String s, final int numRows) {
		int n = s.length(),r = numRows;
		if (r == 1)
			return s;
		char[][] ch = new char[r][n];
		int ni = 2 * (r - 1);
		int[][] iter = new int[2][ni];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < n; j++) 
				ch[i][j] = ' ';
		for (int i = 0; i < r; i++) {
			iter[0][i] = i;
			if (i == 0)
				iter[1][i] = 1;
			else
				iter[1][i] = 0;
		}
		int z = r - 1;
		for (int i = r; i < ni; i++) {
			iter[0][i] = --z;
			iter[1][i] = 1;
		}
		
		int j = 0, c = -1;
		for (int i = 0; i < n; i++) {
			c += iter[1][j];
			ch[iter[0][j]][c] = s.charAt(i);
			j++;
			if (j == ni)
				j = 0;
		}
		String retVal = "";
		for (int i = 0; i < r; i++)
			for (int k = 0; k <= c; k++)
				if (ch[i][k] != ' ')
					retVal += ch[i][k];
		
		return retVal;
	}
}
