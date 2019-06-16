package myspringboot.service;



import org.junit.Assert;
import org.junit.Test;



public class PalindromeTest {
	String longString  = "WasitacaroracatIsaw"; 
			

	@Test
	public void testIsPolindrom() {
		Assert.assertTrue(Palindrome.isPalindrome(""));
		Assert.assertTrue(Palindrome.isPalindrome("abba"));
		Assert.assertTrue(Palindrome.isPalindrome("a"));
		Assert.assertFalse("null failed", Palindrome.isPalindrome(null));
		Assert.assertTrue("Mixed case failed.",Palindrome.isPalindrome("Abba"));
		Assert.assertFalse("Not palindrome failed.",Palindrome.isPalindrome("KKAbbak"));
		Assert.assertTrue(Palindrome.isPalindrome(longString));
	}
	@Test
	public void testIsLispishPolindrom() {
		Assert.assertTrue(Palindrome.isLispishPalindrome(""));
		Assert.assertTrue(Palindrome.isLispishPalindrome("abba"));
		Assert.assertTrue(Palindrome.isLispishPalindrome("abmba"));
		
		Assert.assertTrue(Palindrome.isLispishPalindrome("a"));
		Assert.assertFalse("null failed", Palindrome.isLispishPalindrome(null));
		Assert.assertTrue("Mixed case failed.",Palindrome.isLispishPalindrome("Abba"));
		Assert.assertFalse("Not palindrome failed.",Palindrome.isLispishPalindrome("KKAbbak"));
		Assert.assertTrue(Palindrome.isPalindrome(longString));
	}

}
