
package com.example.simplecrm.controller;

import com.example.simplecrm.model.ExpensesClaim;
import com.example.simplecrm.service.ExpensesClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/expensesclaims")
public class ExpensesClaimsController {

  private final ExpensesClaimService expensesClaimService;

  @Autowired
  public ExpensesClaimsController(ExpensesClaimService expensesClaimService) {
    this.expensesClaimService = expensesClaimService;
  }

  @PostMapping("")
  public ResponseEntity<ExpensesClaim> createExpensesClaim(@Valid @RequestBody ExpensesClaim expensesClaim) {
    ExpensesClaim createdExpensesClaim = expensesClaimService.createExpensesClaim(expensesClaim);
    return new ResponseEntity<>(createdExpensesClaim, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ExpensesClaim> getExpensesClaim(@PathVariable Long id) {
    ExpensesClaim expensesClaim = expensesClaimService.getExpensesClaim(id);
    return new ResponseEntity<>(expensesClaim, HttpStatus.OK);
  }

  @GetMapping("")
  public ResponseEntity<List<ExpensesClaim>> getAllExpensesClaims() {
    List<ExpensesClaim> expensesClaims = expensesClaimService.getAllExpensesClaims();
    return new ResponseEntity<>(expensesClaims, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ExpensesClaim> updateExpensesClaim(
      @PathVariable Long id, @Valid @RequestBody ExpensesClaim expensesClaim) {
    ExpensesClaim updatedExpensesClaim = expensesClaimService.updateExpensesClaim(id, expensesClaim);
    return new ResponseEntity<>(updatedExpensesClaim, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteExpensesClaim(@PathVariable Long id) {
    expensesClaimService.deleteExpensesClaim(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
