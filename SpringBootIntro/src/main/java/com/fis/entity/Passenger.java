package com.fis.entity;

public class Passenger {

	private String name;
	private Gender gender;
	private Status status;
	
	public static enum Gender {
		MALE, FEMALE, OTHER;
	}
	
	public static enum Status {
		WAITING, RAC, CONFIRMED;
	}
	
	public Passenger() {
	}
	public Passenger(String name, Gender gender, Status status) {
		this.name = name;
		this.gender = gender;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
