package com.ss.rest.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ss.rest.entity.Employee;

public interface EmployeeService {
	
	public String enterEmployeeDetails(@RequestBody Employee emp);
     
	public List<Employee> getAllEmployee();
	
	public String  getEmployeeById(Integer empNo);
	
	public String updateEmployeeDetails(Integer empNo, Employee emp);
	
	public List<Employee> getEmployeeSortedOrder();
	
	public String deleteEmployee(Integer empNo);
		
	
}
