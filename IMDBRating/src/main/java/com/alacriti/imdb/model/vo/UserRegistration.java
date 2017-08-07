package com.alacriti.imdb.model.vo;

public class UserRegistration {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String passwordRepeat;
	private String address;
	private String mobileno;
	private boolean isRegCreated=false;
	
	public boolean isRegCreated() {
		return isRegCreated;
	}
	public void setRegCreated(boolean isRegCreated) {
		this.isRegCreated = isRegCreated;
	}
	public UserRegistration(){
		
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public UserRegistration(String firstName, String lastName, String email,
			String password, String passwordRepeat,String address, String mobileno) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileno = mobileno;
		this.passwordRepeat=passwordRepeat;
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	

}
