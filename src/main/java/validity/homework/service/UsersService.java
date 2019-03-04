package validity.homework.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import validity.homework.controller.ResourceConstants;
import validity.homework.model.User;
import validity.homework.model.UsersGroup;

@Service
public class UsersService {

	public List<User> getAllUsers() throws IOException {
		// parse the csv file
		List<List<String>> records = DataUtils.getDataFromCsv(ResourceConstants.CSV_FILE_PATH);
		// convert records to users
		List<User> users = DataUtils.getUsersFromRecords(records);
		return users;
	}

	public UsersGroup processUsers() throws IOException {
		// unique set of nonDuplicates
		List<User> unique = new ArrayList<User>();

		// unique set of duplicates
		List<User> duplicates = new ArrayList<User>();
		List<List<String>> records = DataUtils.getDataFromCsv(ResourceConstants.CSV_FILE_PATH);
		List<User> users = DataUtils.getUsersFromRecords(records);
		DataUtils.sortUsersByEmail(users);
		String curr = users.get(0).getEmail();
		// start from the second element
		for (int i = 1; i < users.size(); i++) {
			if (users.get(i).getEmail().trim().equalsIgnoreCase(curr)) {
				 if(i ==1) {
				    	//if #1 is duplicate of #0, add 0, as well
				    	duplicates.add(users.get(0));
				  }
				duplicates.add(users.get(i));
			   
			} else {
				 if(i ==1) {
				    	//if #1 is different from #0, add 0, as well
				    	unique.add(users.get(0));
				  }
				unique.add(users.get(i));
			}
			curr = users.get(i).getEmail().trim();
		}
		UsersGroup group = new UsersGroup(unique, duplicates);
		return group;
	}

	public List<User> getDuplicates() {
		return null;

	}

}
