package com.ariz.lcsolutions;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcdefghijklmnopqrsguvwxyzabcdeftl1234567890@#?!-_+=*/\\[]{}e"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("a"));
		System.out.println(lengthOfLongestSubstring("abcdefghijklmnopqrsguvwxyzabcdeftl1234567890@#?!-_+=*/\\[]{}m"));
	}
	
	private static int lengthOfLongestSubstring(String s) {
		HashMap<Integer,Integer> map = new HashMap<>();
        if (s.isEmpty())
        	return 0;
        int maxLength = 1,lastBreakpoint = 0;
        int i = 0;
        for (; i < s.length(); i++) {
        	if (map.get((int)s.charAt(i)) != null) {
        		//maxLength = length > maxLength ? length : maxLength;
        		int val = map.get((int)s.charAt(i));
        		if (val >= lastBreakpoint && val < i) {
        			int curLength = i - lastBreakpoint;
        			maxLength = curLength > maxLength ? curLength : maxLength;
        			lastBreakpoint = val + 1;
        		}
        	}
        	map.put((int)s.charAt(i),i);
        }
        int curLength = i - lastBreakpoint;
		maxLength = curLength > maxLength ? curLength : maxLength;
        map.clear();
        map = null;
        return maxLength;
    }
}
