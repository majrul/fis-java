package com.fis.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "tbl_emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;
	
	private String name;
	private double salary;
	
	@Column(name = "date_of_joining")
	//@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfJoining;
	
	public Employee() {
	}
	public Employee(String name, double salary, LocalDate dateOfJoining) {
		super();
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}
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
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = LocalDate.parse(dateOfJoining);
	}
	
}
