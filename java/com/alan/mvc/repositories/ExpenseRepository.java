package com.alan.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alan.mvc.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> { 
	
	List<Expense> findAll();
	
	

}
