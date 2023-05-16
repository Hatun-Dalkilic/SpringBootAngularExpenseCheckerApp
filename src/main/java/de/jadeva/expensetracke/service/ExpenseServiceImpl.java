package de.jadeva.expensetracke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jadeva.expensetracker.model.Expense;
import de.jadeva.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenceRepo;

	@Override
	public List<Expense> findAll() {
		return expenceRepo.findAll();		
	}

	

}
