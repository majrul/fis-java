package com.fis.oop.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		//return e1.getEmpno() - e2.getEmpno();
		int order = e1.getName().compareTo(e2.getName());
		if(order == 0)
			order = Double.compare(e1.getSalary(), e2.getSalary());
		return order;
	}
}

public class Example5 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(10);
		list.add(40);
		list.add(20);
		list.add(50);
		
		Collections.sort(list);
		
		for(Integer no : list)
			System.out.println(no);
		
		List<Employee> listOfEmps = new ArrayList<>();
		//Employee e1 = new Employee();
		//listOfEmps.add(e1);
		listOfEmps.add(new Employee(1005, "Abhishek", 20000));
		listOfEmps.add(new Employee(1003, "Abhishek", 15000));
		listOfEmps.add(new Employee(1001, "Prakash", 15000));
		listOfEmps.add(new Employee(1004, "Charith", 30000));
		listOfEmps.add(new Employee(1002, "Chitra", 20000));
		
		EmployeeComparator comp = new EmployeeComparator();
		//Collections.sort(listOfEmps, comp);
		Collections.sort(listOfEmps, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		//Collections.sort(listOfEmps, new EmployeeSorter());
		//listOfEmps.sort(new EmployeeSorter());
		
		for(Employee emp : listOfEmps)
			System.out.println(emp);
	}
}
