package com.example.simplecrm.service;

import com.example.simplecrm.model.ExpensesClaim;
import java.util.List;

public interface ExpensesClaimService {
  ExpensesClaim createExpensesClaim(ExpensesClaim expensesClaim);

  ExpensesClaim getExpensesClaim(Long id);

  List<ExpensesClaim> getAllExpensesClaims();

  ExpensesClaim updateExpensesClaim(Long id, ExpensesClaim expensesClaim);

  void deleteExpensesClaim(Long id);
}
