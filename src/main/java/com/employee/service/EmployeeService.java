package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.entity.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	
	public Employee retrieveEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();
	}
	
    public Employee updateEmployee(int id,String name) {
		
		Optional<Employee> employeeDetails = employeeRepository.findById(id);
		
		employeeDetails.get().setName(name);
		//employeeDetails.get().setAddress(employee.getAddress());
		//employeeDetails.get().setPhoneNo(employee.getPhoneNo());
		
		employeeRepository.save(employeeDetails.get());
		return employeeDetails.get();
	}
    public Employee updateEmployeeDetails( int id,Employee employee) {
    	Optional<Employee> employeeDetails = employeeRepository.findById(id);
    	
    	employeeDetails.get().setAddress(employee.getAddress());
    	employeeDetails.get().setPhoneNo(employee.getPhoneNo());
      
    	employeeRepository.save(employeeDetails.get());
    	return employeeDetails.get();
    }
    
      public List<Employee> retrieveAllEmployees(){
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
	}
	
	
      public void deleteEmployee(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		employeeRepository.deleteById(id);
	}
	 
      public Employee Login( int id,String name) {
    	  Employee employee = employeeRepository.findByIdAndName(id,name);
    		  return employee;
    	  
    	 
    	 }
}
