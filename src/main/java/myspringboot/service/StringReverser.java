package myspringboot.service;

public class StringReverser {
	public static String reverse(String str) {
		if(str ==null) return null;
		//should I?
		// case sensitive?
		char[] chars = str.trim().toCharArray();
		int l = chars.length;
		char[] chars2 = new char[l];
		for (int i = 0; i < l; i++) {
			chars2[l - 1 - i] = chars[i];
		}

		return new String(chars2);

	}
}
