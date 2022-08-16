package com.ss.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ss.rest.entity.Employee;
import com.ss.rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public String enterEmployeeDetails(Employee emp) {
		if( emp.getEname()!=null && emp.getLoc()!=null && emp.getSal()!=null) {
           repository.save(emp);
			return "employee added";
		}
		else
			return "employee not save";	
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = repository.findAll();
		return employees;
	}

	@Override
	public String getEmployeeById(Integer empNo) {
		Optional<Employee> empbyId = repository.findById(empNo);
		if(empbyId.isPresent())
			return empbyId.toString();
					
		return  "Employee not preset";
	}

	@Override
	public String updateEmployeeDetails(Integer empNo, Employee emp) {
		Optional<Employee> empId = repository.findById(empNo);
		if(empId.isPresent()) {
			emp.setEno(empNo);
			if( emp.getEname()!=null && emp.getLoc()!=null && emp.getSal()!=null)
			repository.save(emp);
			
				return "employee updated";
		}
			else 
				return "employee  not present";	
	}

	
	@Override
	public List<Employee> getEmployeeSortedOrder() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "ename"));
	}

	@Override
	public String deleteEmployee(Integer empNo) {
		Optional<Employee> empById = repository.findById(empNo);
		if(empById.isPresent()) {
			repository.deleteById(empNo);
			    return "Employee Deleted";
        }
		else
			return "Employee not available to delete";
	}

}
