package com.employee.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository< Employee,Integer> {

	public Employee findByIdAndName(int id, String name); 
		
	
	
}
