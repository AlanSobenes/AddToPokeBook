package com.alan.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.alan.mvc.models.Expense;
import com.alan.mvc.repositories.ExpenseRepository;

@Service
public class ExpenseService {
//	----------------DEPENDENCY INJECTION----------------
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
//  -------------------------------------------------	
	 // returns all Expenses
	public List<Expense> allExpenses() {
	        return expenseRepository.findAll();
	    }
	 // creates an Expense
	 public Expense createExpense(Expense e) {
	        return expenseRepository.save(e);
	    }
	 // retrieves an Expense
	 public Expense findExpense(Long id){
		 Optional<Expense> optionalExpense = expenseRepository.findById(id);
		 if(optionalExpense.isPresent()) {
			 return optionalExpense.get();
		 }else {
			 return null;
		 }
	 }
	
	 // delete an Expense by ID
	 public void deleteExpense(Long id) {
		 expenseRepository.deleteById(id);
	 }
	 
	 
	 
	 
}
