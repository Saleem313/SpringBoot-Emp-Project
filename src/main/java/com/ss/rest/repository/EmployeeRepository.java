package com.ss.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ss.rest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
