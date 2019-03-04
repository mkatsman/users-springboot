package validity.homework.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import validity.homework.model.User;

public class DataUtils {
	final static ObjectMapper mapper = new ObjectMapper();

	public static List<String> getData(String filePath, String titleToSearchFor) throws IOException {
		Path path = Paths.get(filePath);

		if (Files.exists(path)) {
			List<String> lines = Files.readAllLines(path);

			List<String> columns = Arrays.asList(lines.get(0).split(","));

			int titleIndex = columns.indexOf(titleToSearchFor);

			List<String> values = lines.stream().skip(1).map(line -> Arrays.asList(line.split(",")))
					.map(list -> list.get(titleIndex)).filter(Objects::nonNull).filter(s -> s.trim().length() > 0)
					.collect(Collectors.toList());

			return values;
		}

		return new ArrayList<>();

	}

	public static  List<User> sortUsersByEmail(List<User> users) {
		users.sort((User o1, User o2) -> o1.getEmail().compareTo(o2.getEmail()));
		return users;
	}

	public static List<User> sortUsersByLastAndFirstName(List<User> users) {

		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				return new CompareToBuilder().append(u1.getLastName(), u2.getLastName())
						.append(u1.getFirstName(), u2.getFirstName()).toComparison();
			}
		});

		return users;
	}

	/**
	 * Reads the csv file at the locations and converts the result to a collection
	 * of records, where each record is the collection of Strings
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static List<List<String>> getDataFromCsv(String filePath) throws IOException {
		Path path = Paths.get(filePath);

		if (Files.exists(path)) {
			List<String> lines = Files.readAllLines(path);

			List<String> columns = Arrays.asList(lines.get(0).split(","));

			List<List<String>> values = lines.stream().skip(1).map(line -> Arrays.asList(line.split(",")))
					.filter(Objects::nonNull).collect(Collectors.toList());

			return values;
		}

		return new ArrayList<>();

	}

	/**
	 * Converts each record to a single User
	 * 
	 * @param records
	 * @return
	 */
	public static List<User> getUsersFromRecords(List<List<String>> records) {
		List<User> users = new ArrayList<User>();
		for (List<String> record : records) {
			User user = new User(record);
			users.add(user);
		}
		return users;
	}

	/**
	 * Gets a POJO from json, providing the class.
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	public static <T> T getObjectFromJson(final String json, final Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		return mapper.readValue(json, clazz);
	}

	/**
	 * Gets List of POJOs from json, providing the POJO class.
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> List<T> getListfromJson(String json, final Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
		List<T> result = mapper.readValue(json, type);
		return result;
	}

	/**
	 * Converst a POJO to json
	 * 
	 * @param obj
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String convertToJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {

		return new String(mapper.writeValueAsBytes(obj), "UTF-8");
	}

}
