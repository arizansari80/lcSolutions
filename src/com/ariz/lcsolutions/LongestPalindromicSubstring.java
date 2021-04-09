package com.ariz.lcsolutions;

public class LongestPalindromicSubstring {
	public static void mainFunc(String[] args) {
		String lP = longestPalindromic("abbc");
		System.out.println(lP);
		System.out.println(lP.length());
	}
	
	private static String longestPalindromic(final String s) {
		int n = s.length();
		boolean table[][] = new boolean[n][n];
		int maxLength = 1;
		int start = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (i == j)
					table[i][j] = true;
				else
					table[i][j] = false;
			if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
				maxLength = 2;
				start = i;
				table[i][i + 1] = true;
			}
		}
		
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j) && k >= maxLength) {
					maxLength = k;
					start = i;
					table[i][j] = true;
				}
			}
		}
		
		return s.substring(start, start + maxLength);
	}
}
