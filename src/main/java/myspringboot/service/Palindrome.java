package myspringboot.service;

import org.springframework.lang.NonNull;

public class Palindrome {

	public static boolean isPalindrome(@NonNull String word) {
		if (word == null)
			return false;

		char[] arr1 = word.toLowerCase().trim().toCharArray();

		int l = arr1.length;
		int halfLengthFloor = arr1.length / 2; // Note truncating, integer division

		for (int i = 0; i < halfLengthFloor; i++) {
			if (arr1[i] != arr1[l - 1 - i]) {
			
			//System.out.println("index to fail"+i);
			return false;
			}
		}
		return true;

	}

	public static boolean isLispishPalindrome(@NonNull String rawWord) {
		if (rawWord == null)
			return false;

		String word = rawWord.toLowerCase().trim();
		int length = word.length();

//		if (length <= 1) {
//			return true;
//		}
		String firstHalf = word.substring(0, length / 2); // Truncating, integer division
		String secondHalf = new StringBuilder(word.substring(length - length / 2)).reverse().toString();

		return firstHalf.equals(secondHalf);

	}

	public static boolean isDgPalindrome(@NonNull String rawWord) {
		String word = rawWord.toLowerCase().trim();
		int l = word.length();
		if (l <= 1) {
			return true;
		}

		boolean res = (word.substring(0, 1).equals(word.substring(word.length() - 1)))
				&& isDgPalindrome(word.substring(1, l - 1));
		return res;
	}

}
