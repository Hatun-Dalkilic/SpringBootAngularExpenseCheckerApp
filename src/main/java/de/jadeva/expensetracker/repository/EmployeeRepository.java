package de.jadeva.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.jadeva.expensetracker.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
