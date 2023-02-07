package com.employee.AssetTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.entity.Employee;
import com.employee.entity.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@SpringBootTest

public class EmployeeTestCases {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Test
	void addEmployee() {
		
		Employee employee = new Employee(1,"Prasanthi","Banglore","8374411150","Analyst");
	    
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		Employee employeeDetails = employeeService.addEmployee(employee);
		
		assertThat(employeeDetails.getName().equals(employee.getName()));
		
	}	
		
	@Test
	void retrieveEmployee() {
		
		Employee employee = new Employee(1,"Prasanthi","Banglore","837441150","Analyst");
		
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		
		Employee employeeDetails = employeeService.retrieveEmployeeById(employee.getId());
		
		assertThat(employee.getAddress().equals(employeeDetails.getAddress()));
		
	}
	
	@Test
	    void retrieveAllEmployees() {
		
		List<Employee> employeesList = new ArrayList<>();
		
		Employee employee1 = new Employee(1,"Prasanthi","Banglore","837441150","Analyst");
		Employee employee2 = new Employee(2,"Ashok","Hyderabad","8765945623","Analyst");
		
		employeesList.add(employee1);
		employeesList.add(employee2);
		
		when(employeeRepository.findAll()).thenReturn(employeesList);
		
          List<Employee> employeeList = employeeService.retrieveAllEmployees();
          
            assertEquals(2,employeeList.size());
	}
	
	@Test
	
	    void updateEmployee() {
		
		Employee employee = new Employee(1,"Prasanthi","Mumbai","837441150","Analyst");
		
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		
		Employee employeeDetails = employeeService.updateEmployee(1,"Prasanthi");
		
		assertEquals("Prasanthi",employeeDetails.getName());
		
		verify(employeeRepository,times(1)).findById(employee.getId());
		
	}
	
	@Test
	
	void deleteEmployee() {
		
		Employee employee = new Employee(1,"Prasanthi","Banglore","837441150","Analyst");
		
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		
		employeeService.deleteEmployee(employee.getId());
		
		verify(employeeRepository,times(1)).findById(employee.getId());
		
		verify(employeeRepository,times(1)).deleteById(employee.getId());
	}

}
	
	