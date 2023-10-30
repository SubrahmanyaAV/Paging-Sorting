package com.fintellix.paginationsorting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fintellix.paginationsorting.entity.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	List<Employee> findAll();

	@Query("SELECT e FROM Employee e JOIN FETCH e.department")
	List<Employee> findAllEmployeesWithDepartment();

}
