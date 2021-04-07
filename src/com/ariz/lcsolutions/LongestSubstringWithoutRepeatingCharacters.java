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
        int length = 1;
        for (int i = 0; i < s.length(); i++) {
        	if (map.get((int)s.charAt(i)) != null) {
        		length = length > map.size() ? length : map.size();
                i = map.get((int)s.charAt(i));
                map.clear();
                continue;
        	}
        	map.put((int)s.charAt(i),i);
        }
        length = length > map.size() ? length : map.size();
        map.clear();
        map = null;
        return length;
    }
}
