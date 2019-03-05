package validity.homework.model;

import java.util.List;
import java.util.Set;

public class UsersGroup {
	private List<User> uniqueCollection;

	private List<User> duplicateByFullName;
	private List<User> duplicateByEmail;

	/**
	 * Default constructor
	 */
	public UsersGroup() {

	}

	
	public UsersGroup(List<User> uniqueCollection,  List<User> duplicateByEmail, List<User> duplicateByFullName) {
         this.setUniqueCollection(uniqueCollection);
         this.setDuplicateByEmail(duplicateByEmail);
         this.setDuplicateByFullName(duplicateByFullName);
	}

	/**
	 * @return the uniqueCollection
	 */
	public List<User> getUniqueCollection() {
		return uniqueCollection;
	}

	/**
	 * @param uniqueCollection the uniqueCollection to set
	 */
	public void setUniqueCollection(List<User> uniqueCollection) {
		this.uniqueCollection = uniqueCollection;
	}

	/**
	 * @return the duplicateCollection
	 */
	public List<User> getDuplicateByFullName() {
		return duplicateByFullName;
	}

	/**
	 * @param duplicateCollection the duplicateCollection to set
	 */
	public void setDuplicateByFullName(List<User> duplicate) {
		this.duplicateByFullName = duplicate;
	}


	/**
	 * @return the duplicateByEmail
	 */
	public List<User> getDuplicateByEmail() {
		return duplicateByEmail;
	}


	/**
	 * @param duplicateByEmail the duplicateByEmail to set
	 */
	public void setDuplicateByEmail(List<User> duplicateByEmail) {
		this.duplicateByEmail = duplicateByEmail;
	}

}
