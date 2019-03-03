package validity.homework.controller;

import org.springframework.web.bind.annotation.RestController;

import validity.homework.model.User;
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
        return  usersService.getAllUsers();
    }
	@RequestMapping(value = ResourceConstants.DISTINCT_USERS, method = RequestMethod.GET)
	public List<User> getDistinctUsers() throws IOException {
        return  usersService.getAllUsers();
    }
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    
}
