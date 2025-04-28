package contact;

public class Contact {
	private final String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		if (id == null || id.length()> 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (firstName == null || firstName.length()> 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length()> 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (phoneNumber == null || phoneNumber.length() != 10 || !(phoneNumber.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (address == null || address.length()> 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
	    if (firstName == null || firstName.length() > 10) {
	        throw new IllegalArgumentException("Invalid First Name");
	    }
	    this.firstName = firstName;
	}
	public void setLastName(String lastName) {
	    if (lastName == null || lastName.length() > 10) {
	        throw new IllegalArgumentException("Invalid Last Name");
	    }
	    this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
	    if (phoneNumber == null || phoneNumber.length() != 10 || !(phoneNumber.chars().allMatch(Character::isDigit))) {
	        throw new IllegalArgumentException("Invalid Phone Number");
	    }
	    this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
	    if (address == null || address.length() > 30) {
	        throw new IllegalArgumentException("Invalid Address");
	    }
	    this.address = address;
	}
}
