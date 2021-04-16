package com.ariz.lcsolutions;

import java.util.ArrayList;
import java.util.HashSet;

class Data {
	int value;
	HashSet<Integer> index;
	
	Data(final int value,final int index) {
		this.value = value;
		this.index = new HashSet<>();
		this.index.add(index);
	}
	
	void insert(final int index) {
		this.index.add(index);
	}
}

class Node {
	Data data;
	Node left;
	Node right;
	
	Node(final int value, final int index) {
		data = new Data(value,index);
		left = null;
		right = null;
	}
}

class BinaryTree {
	Node root;
	
	BinaryTree() {
		root = null;
	}
	
	void insert(final int value, final int index) {
		if (root == null) {
			root = new Node(value,index);
			return;
		}
		
		Node traversal = root;
		Node temp = null;
		boolean isLeft = true;
		while (traversal != null) {
			if (value == traversal.data.value) {
				traversal.data.insert(index);
				return;
			}
			temp = traversal;
			if (value < traversal.data.value) {
				traversal = traversal.left;
				isLeft = true;
			}
			else {
				traversal = traversal.right;
				isLeft = false;
			}
		}
		
		traversal = new Node(value,index);
		if (isLeft)
			temp.left = traversal;
		else
			temp.right = traversal;
	}
	
	void getSortedTree(Node root, ArrayList<Data> data) {
		if (root == null)
			return;
		getSortedTree(root.right,data);
		data.add(root.data);
		getSortedTree(root.left,data);
	}
	
	
}

public class MostWater {
	private static int getArea(final int[] height, final int i, final int j) {
		return (j - i) * Math.min(height[i],height[j]);
	}
	
	private static int getMaxArea(final int[] saved, final int i, final int area) {
		return Math.max(area, Math.max(saved[i], saved[i + 1]));
	}
	
	public static int maxArea(int[] height) {
		int n = height.length;
		/*BinaryTree bt = new BinaryTree();
		for (int i = 0; i < n; i++)
			bt.insert(height[i], i);*/
		
		int maxArea = 0;
		/*ArrayList<Data> sortedData = new ArrayList<>();
		bt.getSortedTree(bt.root, sortedData);
		for (Data elem : sortedData) {
			
		}*/
		int[] saved = new int[n];
		for (int k = 2; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k -1;
				int area = getMaxArea(saved,i,getArea(height,i,j));
				saved[i] = area;
				if (area > maxArea)
					maxArea = area;
			}
		}
        return maxArea;
    }
}
