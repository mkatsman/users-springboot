package validity.homework.model;

import java.util.List;
import java.util.Set;

public class UsersGroup {
	private List<User> uniqueCollection;

	private List<User> duplicateCollection;

	/**
	 * Default constructor
	 */
	public UsersGroup() {

	}

	
	public UsersGroup(List<User> uniqueCollection,  List<User> duplicateCollection) {
         this.setUniqueCollection(uniqueCollection);
         this.setDuplicateCollection(duplicateCollection);
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
	public List<User> getDuplicateCollection() {
		return duplicateCollection;
	}

	/**
	 * @param duplicateCollection the duplicateCollection to set
	 */
	public void setDuplicateCollection(List<User> duplicateCollection) {
		this.duplicateCollection = duplicateCollection;
	}

}
