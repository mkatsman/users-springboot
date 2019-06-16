package myspringboot.service;

public class FooBar {
	/**
	 * Write a function called FooBar that takes input integer n and prints all the
	 * numbers from 1 upto n in a new line. If the number is divisible by 3 then
	 * print "Foo", if the number is divisible by 5 then print "Bar" and if the
	 * number is divisible by both 3 and 5, print "FooBar". Otherwise just print the
	 * number. for example FooBar(15) should print as follows: 1 2 Foo 4 Bar Foo 7 8
	 * Foo Bar 11 Foo 13 14 FooBar
	 * 
	 * @return
	 */
	public static String fooBar(Integer n) {
	
		if (n % 3 == 0 && n % 5 == 0) {
			return "FooBar";
		} else if (n % 3 == 0) {
			return "Foo";
		} else if (n % 5 == 0) {
			return "Bar";

		} else
			return String.valueOf(n);

	}
	
	
}