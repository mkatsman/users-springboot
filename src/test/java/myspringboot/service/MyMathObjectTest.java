package myspringboot.service;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import myspringboot.service.MyMathObject;


@Ignore
public class MyMathObjectTest {
	MyMathObject mmo =null;
	@Before
	public void init(){
		 mmo = new MyMathObject();
	}
	
	@Test
	public void testAdd() {
		Assert.assertNotNull(mmo.add(2,3));
		Assert.assertEquals(7, mmo.add(4,3));
		
		
	}

	@Test
	public void testSubtract() {
		Assert.assertNotNull(mmo.subtract(2,3));
		Assert.assertEquals(-1, mmo.add(2,3));
		
	}
	
}
