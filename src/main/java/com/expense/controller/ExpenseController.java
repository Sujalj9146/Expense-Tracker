package com.expense.controller;

import com.expense.model.Expense;
import com.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public Expense addExpense(@RequestBody Expense e) {
        return service.addExpense(e);
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    @GetMapping("/total")
    public Map<String, Double> getTotal() {
        return Map.of("total", service.getTotal());
    }
}