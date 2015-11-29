package edu.benilde.eat_twenty_four_seven;

public class Recipient {
	
	//fields
	private String firstName;
	private String lastName;
	private String gender;
	private String contactNo;
	private String country;
	private String completeAddress;
	private String postalCode;
	private String landmark;
	private String specialInstructionOrMessage;
	
	//constructor
	public Recipient() {
		firstName = "none";
		lastName = "none";
		gender = "none";
		contactNo = "none";
		country = "none";
		completeAddress  = "none";
		postalCode = "none";
		landmark = "none";
		specialInstructionOrMessage = "none";
	}
	
	//getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCompleteAddress() {
		return completeAddress;
	}
	
	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLandmark() {
		return landmark;
	}
	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	public String getSpecialInstructionOrMessage() {
		return specialInstructionOrMessage;
	}
	
	public void setSpecialInstructionOrMessage(String specialInstructionOrMessage) {
		this.specialInstructionOrMessage = specialInstructionOrMessage;
	}
	
}
