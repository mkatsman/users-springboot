package myspringboot.service;

import org.junit.Assert;
import org.junit.Test;



public class StringReverserTest {

	@Test
	public void testReverseString(){
		Assert.assertEquals("cba", StringReverser.reverse("abc"));
		Assert.assertNull(null, StringReverser.reverse(null));
		Assert.assertEquals("a", StringReverser.reverse("a"));
		Assert.assertEquals("cbA", StringReverser.reverse("Abc"));
		Assert.assertEquals("DcbA", StringReverser.reverse("AbcD"));
		Assert.assertNotEquals("d cbA ", StringReverser.reverse(" Abc D"));
	}
}
