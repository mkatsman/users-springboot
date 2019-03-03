package validity.homework.service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import validity.homework.model.User;

public class DatataUtilsTest {

	@Test
	public void testData() throws IOException {

		//get all lines and each line   as  collection of strings String
		List<List<String>> records = DataUtils.getDataFromCsv("src/main/resources/normal.csv");
		Assert.assertTrue(records.size()>0);
		//Convert each line to a user object , get a collection of users.
		List<User> users = DataUtils.getUsersFromRecords(records);
		
	
		Assert.assertEquals(records.size(), users.size());
	}

}
