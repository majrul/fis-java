package com.fis.oop;

import java.time.LocalDate;

public class Employee4 {

	private int empno;
	private String name;
	private double salary;
	private LocalDate dateOfJoining;

	//constructor
	public Employee4(int empno, String name, double salary, LocalDate dateOfJoining) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
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
		Employee4 emp1 = new Employee4(1001, "Harsh", 30000, LocalDate.of(2022, 6, 30));		
		emp1.info();

		Employee4 emp2 = new Employee4(1002, "Mohit", 30000, LocalDate.of(2022, 6, 30));
		emp2.info();
				
	}
}
