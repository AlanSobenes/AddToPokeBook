package com.alan.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alan.mvc.models.Expense;
import com.alan.mvc.services.ExpenseService;



@Controller
public class MainController {
//	----------------DEPENDENCY INJECTION----------------
	private final ExpenseService expenseService;
	
	public MainController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
//  -------------------------------------------------
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	 @RequestMapping(value="/newExpense", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            expenseService.createExpense(expense);
	            return "redirect:/";
	        }
	    }
}
