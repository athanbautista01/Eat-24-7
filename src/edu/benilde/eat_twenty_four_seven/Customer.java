package edu.benilde.eat_twenty_four_seven;

public class Customer {
	
	//fields
	private String accountType;
	private String firstName;
	private String middleName;
	private String lastName;
	private String birthDate;
	private String gender;
	private String country;
	private String completeAddress;
	private String postalCode;
	private String contactNo;
	private String email;
	private String confirmEmail;
	private String password;
	private String confirmPassword;
	private String action;
	
	//constructor
	public Customer() {
		accountType = "none";
		firstName = "none";
		middleName = "none";
		lastName = "none";
		birthDate = "none";
		gender = "none";
		country = "none";
		completeAddress = "none";
		postalCode = "none";
		contactNo = "none";
		email  = "none";
		confirmEmail = "none";
		password = "none";
		confirmPassword = "none";
		action = "none";
	}
	
	//getters and setters
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
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
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getConfirmEmail() {
		return confirmEmail;
	}
	
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
}
