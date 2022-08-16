package com.ss.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.rest.entity.Employee;
import com.ss.rest.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/welcomeMsg")
	public String welcomeMethod() {
		return  "Welcome to RestController";
	}
	
	//method for request param
	@GetMapping("/welcomeMsgParam")
	 public String welcomeMsgRequestParam(@RequestParam(name = "name",defaultValue = "Saleem") String name) {
		 return "Welcome to RestController "+name;
	 }
	
	@GetMapping("/welcomeMsgPath/{company}")
	public String WelcomeMsgPathVariable(@PathVariable( name = "company", required = false) String company) {
		return "Welcome to company "+company;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee emp ) {
		String enterEmployeeDetails = service.enterEmployeeDetails(emp);
		return enterEmployeeDetails;
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/getAllEmployeeSorted")
	public List<Employee> getAllEmployeeSortedByName(){
		return service.getEmployeeSortedOrder();
	}
	
	@PutMapping("/updateEmployee/{eno}")
	public String updateEmployee(@PathVariable(name = "eno") Integer eno, @RequestBody Employee emp) {
		return service.updateEmployeeDetails(eno, emp);
	}
	
	@GetMapping("/getEmployeeById")
	public String  getEmployeeByEmpno(@RequestParam(name = "eno", required = true) Integer eno) {
		return service.getEmployeeById(eno);
	}
	
	@DeleteMapping("/deleteEmployeeById/{eno}")
	public String deleteEmployeeByEmpno(@PathVariable(name = "eno") Integer eno) {
		return service.deleteEmployee(eno);
	}

}
