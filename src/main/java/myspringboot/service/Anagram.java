package myspringboot.service;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	/**
	 * Tests if two words are anagrams
	 */
	public static boolean areAnagrams(String w1, String w2) {
		if (w1 == null || w2 == null)
			return false;
		if (w1.length() != w2.length())
			return false;
		String lw1 = w1.toLowerCase().trim();
		String lw2 = w2.toLowerCase().trim();
	
		Map<Character, Integer> map = new HashMap<Character, Integer>();
// build a map of the individual characters count for the first word
		for (char ch : lw1.toCharArray()) {
			Integer cnt = map.get(ch);
			if (cnt == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, ++cnt);
			}
		}
		//loop through the second word and subtract the char found. 
		for (char ch : lw2.toCharArray()) {
			Integer cnt = map.get(ch);
			//not found
			if (cnt == null )
				return false;
			//already 0 before subtraction.
			if (cnt == 0)
				return false;
			map.put(ch, cnt - 1);

		}
		//loop through the map values and see if they are all 0s;	
		
		for (Integer val : map.values()) {
			if (val > 0)
				return false;
		}
		return true;
	}
}
