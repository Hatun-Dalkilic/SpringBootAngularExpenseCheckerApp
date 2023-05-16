package de.jadeva.expensetracke.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.jadeva.expensetracker.exception.ResourceNotFoundException;
import de.jadeva.expensetracker.model.Employee;
import de.jadeva.expensetracker.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public int insertEmployee(Employee employee) {
		if (employee != null) {
			employeeRepo.save(employee);
			return 1;
		}
		return 0;
	}

	@Override
	public ResponseEntity< Map<String, Boolean>> deleteEmployee(long id) {
		 Employee employee = employeeRepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id :" + id));
		  employeeRepo.delete(employee);
		  Map<String, Boolean>response=new HashMap<>();
		  response.put("deleted", Boolean.TRUE);
		  return ResponseEntity.ok(response);
	}

	@Override
	public Employee getEmployeeByID(long id) {
		return employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id :" + id));
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Employee employeeFromDB = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id :" + id));

	
		// save kann auch für update verwendet werden. Es schaut nach ob es sin solches
		// Element vorhanden ist und dührt einen update durch.
		// Wenn nicht, dann speichert es dieses Objekt.
		
//		employeeFromDB.setFirstName(employee.getFirstName());
//		employeeFromDB.setLastName(employee.getLastName());
//		employeeFromDB.setEmailId(employee.getEmailId());
		return employeeRepo.save(employee);
	}

}
