package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Asset;
import com.employee.entity.Employee;
import com.employee.service.AssetService;
import com.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
public class AdminController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AssetService assetService;
	
	@PostMapping("addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println(employee.toString());
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
	
	@GetMapping("retrieveAllEmployees")
	public List<Employee> retrieveAllEmployees(){
		return employeeService.retrieveAllEmployees();
	}
	
	@PostMapping("addAsset")
	public Asset addAsset(@RequestBody Asset asset) {
		return assetService.addAsset(asset);
	}
	
	@GetMapping("retriveAllAssets")
	public List<Asset> retriveAllAssets(){
		return assetService.retrieveAllAssets();
	}
	
	@DeleteMapping("/deleteAsset/{itemNo}")
	public void deleteAsset(@PathVariable("itemNo") int itemNo) {
		assetService.deleteAsset(itemNo);
	}
	
	@PutMapping("/updateAsset/{itemNo}")
	public Asset updateAsset(@RequestBody Asset asset) {
		return assetService.updateAsset(asset);
	}
	
	@GetMapping("/retriveAssetById/{id}")
	public List<Asset> retriveAsset(@PathVariable int id) {
		return assetService.retriveAssetForEmployee(id);
	}
     
	@GetMapping("employee_Login/{empId}/{empName}")
	public Employee Login( @PathVariable("empId")
	int id,@PathVariable("empName") String name) {
		return employeeService.Login(id,name);
		}
	
	@GetMapping("/retrieveEmployeeById/{id}")
	public Employee retrieveEmployee(@PathVariable int id) {
		return employeeService.retrieveEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee/{id}/{name}")
	public Employee updateEmployee(@PathVariable ("id")int id,@PathVariable("name") String name) {
		return employeeService.updateEmployee(id,name);
	}
	
	@PutMapping("/updateEmployeeDetails/{id}")
	public Employee updateEmployeeDetails(@PathVariable("id") int id ,@RequestBody Employee employee) {
		return employeeService.updateEmployeeDetails(id ,employee);
		
	}

}
