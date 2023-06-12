package com.example.simplecrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesClaimService {

  private final ExpensesClaimRepository expensesClaimRepository;

  @Autowired
  public ExpensesClaimService(ExpensesClaimRepository expensesClaimRepository) {
    this.expensesClaimRepository = expensesClaimRepository;
  }

  public List<ExpensesClaim> getAllExpenses() {
    return expensesClaimRepository.findAll();
  }

  public ExpensesClaim getExpenseById(Long id) {
    return expensesClaimRepository.findById(id).orElse(null);
  }

  public ExpensesClaim createExpense(ExpensesClaim expense) {
    return expensesClaimRepository.save(expense);
  }

  public ExpensesClaim updateExpense(Long id, ExpensesClaim expense) {
    ExpensesClaim existingExpense = expensesClaimRepository.findById(id).orElse(null);
    if (existingExpense != null) {
      // Update the properties of the existing expense with the new values
      existingExpense.setCreatedDate(expense.getCreatedDate());
      existingExpense.setAmount(expense.getAmount());
      existingExpense.setApprovedBySupervisor(expense.getApprovedBySupervisor());
      existingExpense.setApprovedDateTimeSupervisor(expense.getApprovedDateTimeSupervisor());
      existingExpense.setApprovedByHOD(expense.getApprovedByHOD());
      existingExpense.setApprovedDateTimeHOD(expense.getApprovedDateTimeHOD());
      existingExpense.setCreatedBy(expense.getCreatedBy());
      existingExpense.setTypeOfClaim(expense.getTypeOfClaim());
      existingExpense.setRemarks(expense.getRemarks());
      existingExpense.setPersonRejected(expense.getPersonRejected());

      return expensesClaimRepository.save(existingExpense);
    } else {
      return null;
    }
  }

  public boolean deleteExpense(Long id) {
    ExpensesClaim existingExpense = expensesClaimRepository.findById(id).orElse(null);
    if (existingExpense != null) {
      expensesClaimRepository.delete(existingExpense);
      return true;
    } else {
      return false;
    }
  }
}
