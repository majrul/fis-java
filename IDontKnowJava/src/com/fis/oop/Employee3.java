package com.fis.oop;

import java.time.LocalDate;

public class Employee3 {

	int empno;
	String name;
	double salary;
	LocalDate dateOfJoining;

	//constructor
	Employee3(int empno, String name, double salary, LocalDate dateOfJoining) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	void info() {
		System.out.println("-------------");
		System.out.println("Empno = " + empno);
		System.out.println("Name = " + name);
		System.out.println("Salary = " + salary);
		System.out.println("Date of Joining = " + dateOfJoining);
	}
	
	public static void main(String[] args) {
		//creating an object reference
		Employee3 emp1 = new Employee3(1001, "Harsh", 30000, LocalDate.of(2022, 6, 30));		
		emp1.info();

		Employee3 emp2 = new Employee3(1002, "Mohit", 30000, LocalDate.of(2022, 6, 30));
		emp2.info();
				
	}
}
