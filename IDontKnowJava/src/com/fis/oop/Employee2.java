package com.fis.oop;

import java.time.LocalDate;

public class Employee2 {

	int empno;
	String name;
	double salary;
	LocalDate dateOfJoining;
	
	void info() {
		System.out.println("-------------");
		System.out.println("Empno = " + empno);
		System.out.println("Name = " + name);
		System.out.println("Salary = " + salary);
		System.out.println("Date of Joining = " + dateOfJoining);
	}
	
	public static void main(String[] args) {
		//creating an object reference
		Employee2 emp1 = new Employee2();
		emp1.empno = 1001;
		emp1.name = "Harsh";
		emp1.salary = 30000;
		emp1.dateOfJoining = LocalDate.of(2022, 6, 30);
		
		emp1.info();

		Employee2 emp2 = new Employee2();
		emp2.empno = 1002;
		emp2.name = "Mohit";
		emp2.salary = 30000;
		emp2.dateOfJoining = LocalDate.of(2022, 6, 30);

		emp2.info();
		
		Employee2 emp3 = emp2;
		
		emp3.info();
		
		emp2.salary = 40000;
		System.out.println(emp3.salary);
		
	}
}
