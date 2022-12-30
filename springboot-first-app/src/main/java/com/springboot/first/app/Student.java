package com.springboot.first.app;

public class Student {

	private String first_nameString;
	private String last_nameString;
	public Student(String first_nameString, String last_nameString) {
		super();
		this.first_nameString = first_nameString;
		this.last_nameString = last_nameString;
	}
	public String getFirst_nameString() {
		return first_nameString;
	}
	public void setFirst_nameString(String first_nameString) {
		this.first_nameString = first_nameString;
	}
	public String getLast_nameString() {
		return last_nameString;
	}
	public void setLast_nameString(String last_nameString) {
		this.last_nameString = last_nameString;
	}
	@Override
	public String toString() {
		return "Student [first_nameString=" + first_nameString + ", last_nameString=" + last_nameString + "]";
	}
	
	
}
