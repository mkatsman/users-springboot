package validity.homework.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import mysprinboot.controller.ResourceConstants;
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
		
		List<User> users = getAllUsers();
		
		
		Set<User> unique = getUniqueUsers(users) ;
		
	    List<User> duplicatesByEmail = getDuplicatesByEmail(users);
	    List<User> duplicatesByFullName = getDuplicatesByFullName(users);
		UsersGroup group = new UsersGroup(new ArrayList<User>(unique), 
				duplicatesByEmail, duplicatesByFullName );
		return group;
	}

	public List<User> getDuplicatesByEmail(List<User> users) throws IOException {
		return DataUtils.getDuplicatesByEmail(getAllUsers());
		

	}
	public List<User> getDuplicatesByFullName(List<User> users) throws IOException {
		return DataUtils.getDuplicatesByLastAndFirstName(getAllUsers());
		

	}
	public Set<User> getUniqueUsers(List<User> users) throws IOException {
		return DataUtils.getUnique(users);
		

	}
}
