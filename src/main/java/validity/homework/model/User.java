package validity.homework.model;

import java.util.List;

public class User {

	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ ", email=" + email + ", address1=" + address1 + ", address2=" + address2 + ", zip=" + zip + ", city="
				+ city + ", stateLong=" + stateLong + ", state=" + state + ", phone=" + phone + "]";
	}
	String id;
    String firstName;
	private String lastName;
	private String company;
	private String email;
	private String address1;
	private String address2;
	private String zip;
	private String city;
	private String stateLong;
	private String state;
	private String phone;

	/**
	 * Default constructor for deserialization
	 */
	public User() {

	}
	public User(String emaill, String firstName, String lastName) {
		this.setEmail(emaill);
	    this.setFirstName(lastName);
	    this.setLastName(lastName);
	}
/**
 * format: id	first_name	last_name	company	email	address1	address2	
 * zip	city	state_long	state	phone
 * @param record
 */
	public User(List<String> record) {
		this.id = record.get(0);
		
		this.firstName = record.get(1);
	
		this.setLastName(record.get(2));
		this.setCompany(record.get(3));
		this.setEmail(record.get(4));
		this.setAddress1(record.get(5));
		this.setAddress2(record.get(6));
		this.setZip(record.get(7));
		
		this.setCity(record.get(8));
		this.setStateLong(record.get(9));
		this.setState(record.get(10));
		this.setPhone(record.get(11));
		
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (getEmail() == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!getEmail().equals(other.getEmail()))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (getLastName() == null) {
			if (other.getLastName() != null)
				return false;
		} else if (!getLastName().equals(other.getLastName()))
			return false;
		return true;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address1
	 */
	String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the stateLong
	 */
	public String getStateLong() {
		return stateLong;
	}
	/**
	 * @param stateLong the stateLong to set
	 */
	public void setStateLong(String stateLong) {
		this.stateLong = stateLong;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

} 