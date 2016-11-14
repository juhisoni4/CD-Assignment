package com.crud.with.database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String passWord;

	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Student() {

	}

	public Student(String firstName, String lastName, String email, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", passWord=" + passWord + "]";
	}

	public boolean isValidEmail(String email2) {
		
		final String EMAIL_PATTERN = "^[\\w+_.-]+@+[\\w+\\.]+[\\w]$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email2);
		return matcher.matches();
	}

	public boolean isValidateUserName(String username2) {
		
		final String USER_PATTERN = "^[\\w]{3,15}$";
		Pattern pattern = Pattern.compile(USER_PATTERN);
		Matcher matcher = pattern.matcher(username2);
		return matcher.matches();
		
	}

}
