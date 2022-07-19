package com.fis.oop;

import java.time.LocalDate;

//such a class is commonly referred to as JavaBean
public class Employee5 {

	private int empno;
	private String name;
	private double salary;
	private LocalDate dateOfJoining;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void info() {
		System.out.println("-------------");
		System.out.println("Empno = " + this.empno);
		System.out.println("Name = " + this.name);
		System.out.println("Salary = " + this.salary);
		System.out.println("Date of Joining = " + this.dateOfJoining);
	}
	
	public static void main(String[] args) {
		//creating an object reference
		//compiler provides the default constructor
		Employee5 emp1 = new Employee5();	
		//emp1.setEmpno(1001);
		//emp1.setName("Harsh");
		//emp1.setSalary(30000);
		//emp1.setDateOfJoining(LocalDate.of(2022, 6, 30));
		emp1.info();

		Employee5 emp2 = new Employee5();
		emp2.setEmpno(1001);
		emp2.setName("Harsh");
		emp2.setSalary(30000);
		emp2.setDateOfJoining(LocalDate.of(2022, 6, 30));
		emp2.info();	
	}
}
