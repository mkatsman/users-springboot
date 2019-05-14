package myspringboot.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import myspringboot.service.StackExample;

public class StackeExampleTest {

	@Test
	public void pushtest() {
		int len = 100;
		List list = StackExample.getList(100)
;		Assert.assertEquals(len, list.size());
		list= StackExample.push(6, list);
		Assert.assertTrue(list.size() == len+1);
		
	}

}
