package validity.homework.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import validity.homework.model.User;

public class DatataUtilsTest {

	@Test
	public void testGetData() throws IOException {

		// get all lines and each line as collection of strings String
		List<List<String>> records = DataUtils.getDataFromCsv("src/main/resources/advanced.csv");
		Assert.assertTrue(records.size() > 0);
		// Convert each line to a user object , get a collection of users.
		List<User> users = DataUtils.getUsersFromRecords(records);

		Assert.assertEquals(records.size(), users.size());
	}

	@Test
	public void testGetUnique() throws IOException {

		// get all lines and each line as collection of strings String
		List<List<String>> records = DataUtils.getDataFromCsv("src/main/resources/normal.csv");
		Assert.assertTrue(records.size() > 0);
		// Convert each line to a user object , get a collection of users.
		List<User> users = DataUtils.getUsersFromRecords(records);
		Set<User> uniqueUsers = DataUtils.getUnique(users);
		Assert.assertTrue(uniqueUsers.size() > 0);

		Assert.assertTrue(uniqueUsers.size() < users.size());

		String curr = "-999";
		for (User user : uniqueUsers) {
			Assert.assertFalse("Found duplicate email in unique collection: " + user.getEmail(),
					user.getEmail().equals(curr));
			curr = user.getEmail();
		}
	}



	@Test
	public void testGetDuplicates() throws IOException {

		// get all lines and each line as collection of strings String
		List<List<String>> records = DataUtils.getDataFromCsv("src/main/resources/normal.csv");
		
		Assert.assertTrue(records.size() > 0);
		// Convert each line to a user object , get a collection of users.
		List<User> users = DataUtils.getUsersFromRecords(records);
			System.out.println("Duplicates By Email:");
		// pair each id with its marks
		List<User> duplicates = DataUtils.getDuplicatesByEmail(users);
		duplicates.forEach(System.out::println);
		System.out.println("Duplicates By Full Name:");
		duplicates = DataUtils.getDuplicatesByLastAndFirstName(users);
		duplicates.forEach(System.out::println);
		String curr = "-999";
		boolean found = false;
		
	}

}
