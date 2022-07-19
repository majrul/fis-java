package com.fis.oop;

import java.time.LocalDate;

public class Employee {

	int empno;
	String name;
	double salary;
	LocalDate dateOfJoining;
	
	public static void main(String[] args) {
		//creating an object reference
		Employee emp1 = new Employee();
		emp1.empno = 1001;
		emp1.name = "Harsh";
		emp1.salary = 30000;
		emp1.dateOfJoining = LocalDate.of(2022, 6, 30);
		
		System.out.println(emp1.empno);
		System.out.println(emp1.name);
		System.out.println(emp1.salary);
		System.out.println(emp1.dateOfJoining);

		Employee emp2 = new Employee();
		emp2.empno = 1002;
		emp2.name = "Mohit";
		emp2.salary = 30000;
		emp2.dateOfJoining = LocalDate.of(2022, 6, 30);

		System.out.println(emp2.empno);
		System.out.println(emp2.name);
		System.out.println(emp2.salary);
		System.out.println(emp2.dateOfJoining);
		
		Employee emp3 = emp2;
		System.out.println(emp3.empno);
		System.out.println(emp3.name);
		System.out.println(emp3.salary);
		System.out.println(emp3.dateOfJoining);
		
		emp2.salary = 40000;
		System.out.println(emp3.salary);
		
	}
}
