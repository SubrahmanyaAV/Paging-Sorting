package com.fintellix.paginationsorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fintellix.paginationsorting.entity.Employee;
import com.fintellix.paginationsorting.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * @GetMapping("/pagination-sorting/employees") public
	 * ResponseEntity<Page<Employee>> getEmployees(
	 * 
	 * @PageableDefault(size = 10, sort = "empId", direction = Sort.Direction.ASC)
	 * Pageable pageable) { Page<Employee> employees =
	 * employeeService.getEmployees(pageable); return ResponseEntity.ok(employees);
	 * }
	 */	
	
	@GetMapping("/pagination-sorting/employees/{pageNo}/{pageSize}")
    public Page<Employee> employeePagination(@PathVariable Integer pageNo,
    										 @PathVariable Integer pageSize){
		return employeeService.getEmployeePagination(pageNo, pageSize);
	}
	
	@GetMapping("/pagination-sorting/employees/{pageNo}/{pageSize}/{sort}")
    public Page<Employee> employeePagingAndSort(@PathVariable Integer pageNo,
    										 	@PathVariable Integer pageSize,
    										 	@PathVariable String sort){
		return employeeService.getEmployeePagingAndSort(pageNo, pageSize, sort);
	}

}
