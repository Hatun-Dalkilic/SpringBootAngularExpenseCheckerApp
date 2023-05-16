package de.jadeva.expensetracke.service;

import java.util.List;

import de.jadeva.expensetracker.model.Expense;


public interface ExpenseService {

	 List<Expense> findAll();

}
