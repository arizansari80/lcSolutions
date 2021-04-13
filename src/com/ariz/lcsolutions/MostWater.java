package com.ariz.lcsolutions;

public class MostWater {
	private static int getArea(final int[] height, final int i, final int j) {
		return (j - i) * Math.min(height[i],height[j]);
	}
	
	private static int getMaxArea(final int[][] saved, final int i, final int j, final int area) {
		return Math.max(area, Math.max(saved[i][j - 1], Math.max(saved[i + 1][j], saved[i + 1][j - 1])));
	}
	
	public static int maxArea(int[] height) {
		int n = height.length;
		int[][] saved = new int[n][n];
		int maxArea = 0;
		
		for (int k = 2; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k -1;
				int area = getMaxArea(saved,i,j,getArea(height,i,j));
				saved[i][j] = area;
				if (area > maxArea)
					maxArea = area;
			}
		}
        return maxArea;
    }
}
