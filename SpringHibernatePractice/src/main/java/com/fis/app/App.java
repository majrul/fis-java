package com.fis.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.dao.EmployeeDao;
import com.fis.entity.Employee;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	
		EmployeeDao empDao = ctx.getBean(EmployeeDao.class);
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Deepanjali", 25000, LocalDate.of(2022, 6, 30)));
		list.add(new Employee("Mohit", 25000, LocalDate.of(2022, 6, 30)));
		list.add(new Employee("Charith", 25000, LocalDate.of(2022, 6, 30)));
		list.add(new Employee("Mayur", 25000, LocalDate.of(2022, 6, 30)));
		list.add(new Employee("Vishnu", 25000, LocalDate.of(2022, 6, 30)));
		
		empDao.add(list);
		
		/*Employee emp = new Employee();
		emp.setName("Piyush");
		emp.setSalary(25000);
		emp.setDateOfJoining(LocalDate.of(2022, 6, 20));
		empDao.add(emp);*/
		
		//List<Employee> list = empDao.fetchAll();
		/*List<Employee> list = empDao.fetchBySalary(20000);
		for(Employee emp : list)
			System.out.println(emp.getEmpno() +" , " + emp.getName() + " , " + emp.getSalary() +" , " + emp.getDateOfJoining());*/
		
		
	}
}
