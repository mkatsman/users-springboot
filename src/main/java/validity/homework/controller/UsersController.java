package validity.homework.controller;

import org.springframework.web.bind.annotation.RestController;

import validity.homework.model.User;
import validity.homework.model.UsersGroup;
import validity.homework.service.UsersService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = ResourceConstants.USERS, method = RequestMethod.GET)
	public List<User> getAll() throws IOException {
		return usersService.getAllUsers();
	}

	/**
	 * Reads the CSV file identifies two groups of duplicate and unique. which is
	 * automatically unmarshalled into json
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = ResourceConstants.PROCESS_USERS, method = RequestMethod.GET)
	public UsersGroup processUsers() throws IOException {
		UsersGroup group = usersService.processUsers();
		System.out.println("Unique Users");
		group.getUniqueCollection().forEach(System.out::println);
		System.out.println("Duplicate By Email");
		group.getDuplicateByEmail().forEach(System.out::println);
		System.out.println("Duplicate By Full Name");
		group.getDuplicateByFullName().forEach(System.out::println);
		return group;

	}

	
}
