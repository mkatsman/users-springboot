package myspringboot.service;

import java.io.FileReader;
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
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import com.opencsv.CSVReader;

import myspringboot.controller.ResourceConstants;
import myspringboot.model.User;

public class DataUtils {
	final static ObjectMapper mapper = new ObjectMapper();

	
	

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
		List<List<String>> values = new ArrayList<>() ;

		if (Files.exists(path)) {
			 CSVReader reader = new CSVReader(new FileReader(ResourceConstants.CSV_FILE_PATH));
		     
		     String[] nextLine;
		     while ((nextLine = reader.readNext()) != null) {
		    	    values.add(Arrays.asList(nextLine));
		    	 
		    	}

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
	 * gets the list of unique users based by email.
	 * @param users
	 * @return
	 */
	public static Set<User> getUnique(List<User> users) {

		Comparator<User> uniqueComp = (u1, u2) -> u1.getEmail().trim().toLowerCase().compareTo( u2.getEmail().trim().toLowerCase() );
		TreeSet<User> sortedFilterd = users.stream().sorted().collect(Collectors.toCollection(() -> 
		new TreeSet<User>(uniqueComp)));

		return sortedFilterd;
}

	/**
	 * gets Duplicates by email
	 * @param users
	 * @return
	 */
	public static List<User> getDuplicatesByEmail(List<User> users) {
		
		Comparator<User> comp = (u1, u2) -> u1.getEmail().trim().toLowerCase().compareTo( u2.getEmail().trim().toLowerCase() );
	    //sorted users by email
		
		Collections.sort(users, comp);
		return getDuplicates(users,1);
	}
	/**
	 * gets duplicates by full name
	 * @param users
	 * @return
	 */
	public static List<User> getDuplicatesByLastAndFirstName(List<User> users) {
	    Comparator<User> comp = Comparator
                .comparing(User::getLastName)
                .thenComparing(User::getFirstName);
		
		
		Collections.sort(users, comp);
		return getDuplicates(users,2);
}
	/**
	 *finds duplicates in the list based on the criteria 1 -email; 2 full name
	 * @param users
	 * @param crit
	 * @return
	 */
	public static List<User>  getDuplicates(List<User> users, int crit) {
		List<User> duplicates = new ArrayList<User> ();
		int lastAdded = -5;
		for(int i =1; i< users.size();i++) {
			if (compareUsers(users.get(i),users.get(i-1), crit)){
				
				duplicates.add(users.get(i));
				if((i-1) >lastAdded) {
					duplicates.add(users.get(i-1));
				}
				lastAdded =i;
				
			}
			i++;
			
		}
		
		return duplicates;
	}
	/**
	 * Compares two USERS with tyhe criteria: 1: email, 2 - full name
	 * @param user1
	 * @param user2
	 * @param crit
	 * @return
	 */
	public static boolean compareUsers(User user1, User user2, int crit) {
		boolean result = false;
		if (crit ==1) {
			result = user1.getEmail().trim().toLowerCase().equals(user2.getEmail().trim().toLowerCase());
		}else if(crit ==2) {
			result =  user1.getLastName().trim().toLowerCase().equals(user2.getLastName().trim().toLowerCase());
			result = result &&  user1.getFirstName().trim().toLowerCase().equals(user2.getFirstName().trim().toLowerCase());
		}
		return result;
	}
	/**
	 * Sortds users by full name
	 * @param users
	 * @return
	 */
	public static List<User> sortByFullName(List<User> users){
	    //Compare by first name and then last name
        Comparator<User> compareByName = Comparator
                                                .comparing(User::getLastName)
                                                .thenComparing(User::getFirstName);
        Collections.sort(users, compareByName);
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
