package com.example.simplecrm.exception;

public class ExpensesClaimNotFoundException extends RuntimeException {

  public ExpensesClaimNotFoundException(Long id) {
    super("Expense Claim with id " + id + " not found.");
  }

}