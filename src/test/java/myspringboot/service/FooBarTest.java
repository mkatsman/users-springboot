package myspringboot.service;

import org.junit.Assert;
import org.junit.Test;

public class FooBarTest {
@Test	
public void testFooBar() {
	Assert.assertEquals("Foo", FooBar.fooBar(3));
	Assert.assertEquals("Foo", FooBar.fooBar(6));
	Assert.assertEquals("Foo", FooBar.fooBar(9));
	Assert.assertEquals("Foo", FooBar.fooBar(12));
	Assert.assertEquals("Bar", FooBar.fooBar(5));
	Assert.assertEquals("Bar", FooBar.fooBar(10));
	Assert.assertEquals("FooBar", FooBar.fooBar(15));
	Assert.assertEquals("FooBar", FooBar.fooBar(0));
	Assert.assertEquals("1", FooBar.fooBar(1));
	Assert.assertEquals("2", FooBar.fooBar(2));
	Assert.assertEquals("11", FooBar.fooBar(11));

}
}
