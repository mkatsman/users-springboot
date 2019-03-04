package validity.homework.controller;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import validity.homework.model.User;
import validity.homework.model.UsersGroup;
import validity.homework.service.DataUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersIntegrationTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}

	@Test
	public void getAllUsersTest() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString() + ResourceConstants.USERS,
				String.class);
		List<User> users = DataUtils.getListfromJson(response.getBody(), User.class);

		for (User user : users) {
			System.out.println(user.toString());
			if (!checkUser(user))
				throw new RuntimeException("User info is not complete" + user.toString());

		}
	}

	@Test
	public void processUsersTest() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString() + ResourceConstants.PROCESS_USERS,
				String.class);
		UsersGroup usersGroup = DataUtils.getObjectFromJson(response.getBody(), UsersGroup.class);
		System.out.println("********* Duplicate Users ***********");
		for (User user : usersGroup.getDuplicateCollection()) {
			System.out.println(user.toString());

		}
		System.out.println("********* Unique Users ***********");
		for (User user : usersGroup.getUniqueCollection()) {
			System.out.println(user.toString());

		}
	}

	public void checkIncompleteUserPublishedTest() {
		List<User> users = new ArrayList<User>();
		users.add(new User(null, "Bill", "Smith"));
		users.add(new User("bill@bill", null, "Smith"));
		users.add(new User("bill@bill", "Bill", null));

		Assert.assertEquals("Should be 3 incomplete users in your list", 3, checkUsers(users).size());

	}

	public List<User> checkUsers(List<User> users) {
		List<User> incompleteUsers = new ArrayList<User>();
		for (User user : users) {
			System.out.println(user.toString());
			if (!checkUser(user))
				incompleteUsers.add(user);
			System.out.println("User info is not complete" + user.toString());

		}
		return incompleteUsers;

	}

	public boolean checkUser(User user) {

		return user.getEmail() != null && user.getFirstName() != null && user.getLastName() != null;

	}
}