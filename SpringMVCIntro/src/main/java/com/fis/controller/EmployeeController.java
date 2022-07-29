package com.fis.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fis.dao.EmployeeDao;
import com.fis.entity.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao empDao;
	
	//Spring can automatically copy incoming data in on object
	//Then we don't need to use request.getParameter anymore
	//the only care to be taken is that the form parameter names
	//should match with the properties of the respective class
	@RequestMapping("/add-emp")
	public String add(Employee emp) {
		empDao.add(emp);
		return "confirmation.jsp";
	}
	
	/*@RequestMapping("/add-emp")
	public String add(HttpServletRequest request) {
		Employee emp = new Employee();
		emp.setName(request.getParameter("name"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));
		emp.setDateOfJoining(LocalDate.parse(request.getParameter("doj")));
		
		empDao.add(emp);
		
		return "confirmation.jsp";
	}*/
}
