package com.expense.service;

import com.expense.model.Expense;
import com.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    public Expense addExpense(Expense e) {
        return repo.save(e);
    }

    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    public double getTotal() {
        return repo.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}