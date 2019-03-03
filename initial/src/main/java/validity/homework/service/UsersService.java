package validity.homework.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import validity.homework.controller.ResourceConstants;
import validity.homework.model.User;

@Service
public class UsersService {

	
	
	public List<User> getAllUsers() throws IOException {
		//parse the csv file 
		List<List<String>> records = DataUtils.getDataFromCsv(ResourceConstants.CSV_FILE_PATH);
		//convert records to users
		List<User> users =  DataUtils.getUsersFromRecords(records);
		return users;
	}
	public List<User> removeDuplicates() {
		return null;

	}

	public List<User> getDuplicates() {
		return null;
		
	}
	
}
