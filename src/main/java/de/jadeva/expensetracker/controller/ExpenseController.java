package de.jadeva.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.jadeva.expensetracke.service.ExpenseService;
import de.jadeva.expensetracker.model.Expense;

@RestController
@RequestMapping("api/v1")
public class ExpenseController {

	@Autowired
	 private ExpenseService expenseService;

	@GetMapping("/expenses")
	public ResponseEntity<List<Expense>> get() {
		List<Expense> expenses = expenseService.findAll();
		return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
	}

}
