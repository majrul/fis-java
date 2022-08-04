package com.fis.model;

public class CustomerInfo {

	private int id;
	private String name;
	
	private boolean status;
	private String errorIfAny;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorIfAny() {
		return errorIfAny;
	}
	public void setErrorIfAny(String errorIfAny) {
		this.errorIfAny = errorIfAny;
	}
	
	
}
