package de.jadeva.expensetracke.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import de.jadeva.expensetracker.model.Employee;

public interface EmployeeService {
	
	List<Employee>getAllEmployees();
	int insertEmployee(Employee employee);
	ResponseEntity<Map<String, Boolean>> deleteEmployee(long id);
	Employee getEmployeeByID(long id);
	Employee updateEmployee(long id, Employee employee);
}
