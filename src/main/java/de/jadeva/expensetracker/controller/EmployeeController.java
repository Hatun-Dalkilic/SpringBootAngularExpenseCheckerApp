package de.jadeva.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.jadeva.expensetracke.service.EmployeeService;
import de.jadeva.expensetracker.model.Employee;
import de.jadeva.expensetracker.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeServie;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeServie.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeByID(@PathVariable("id") long id) {
		Employee employee = employeServie.getEmployeeByID(id);
		return employee;
	}

	@GetMapping("/test")
	public String getTest() {

		return "Hello Angular";

	}

	@PostMapping("/employees")
	public int insertEmployeeToDB(@RequestBody Employee employee) {
		return employeServie.insertEmployee(employee);
	}

	@DeleteMapping(path = "/employees/{id}")
	public void deleteEmployeeById(@PathVariable("id") long id) {
		employeServie.deleteEmployee(id);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		Employee employeeUpdated= employeServie.updateEmployee(id, employee);
		return ResponseEntity.ok(employeeUpdated);
	}

}
