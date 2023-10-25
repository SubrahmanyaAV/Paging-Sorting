package com.fintellix.paginationsorting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fintellix.paginationsorting.entity.Employee;
import com.fintellix.paginationsorting.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

	public Page<Employee> getEmployeePagination(Integer pageNo, Integer pageSize) {
		Sort sort = Sort.by(Sort.Direction.ASC, "empName");
		// name property in ascending 
	//	Pageable pageable = PageRequest.of(pageNo, pageSize); //just for pagination
		Pageable pagingAndSort = PageRequest.of(pageNo, pageSize, sort); //for both paging n sort
		return employeeRepository.findAll(pagingAndSort);
	}
	
	//instead of hard coding
	public Page<Employee> getEmployeePagingAndSort(Integer pageNo, Integer pageSize, String sort) {
		Pageable pagingAndSort = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, sort);
		return employeeRepository.findAll(pagingAndSort);
	}
}
