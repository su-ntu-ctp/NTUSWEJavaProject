//App
package com.example.simplecrm.service;

//Java Packages
import java.util.List;
import java.util.Optional;
//spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//App Model/Rep/Exception
import com.example.simplecrm.model.ExpensesClaim;
import com.example.simplecrm.repository.ExpensesClaimRepository;
import com.example.simplecrm.exception.ExpensesClaimNotFoundException;

@Service
public class ExpensesClaimServiceImpl implements ExpensesClaimService {

  private final ExpensesClaimRepository expensesClaimRepository;

  @Autowired
  public ExpensesClaimServiceImpl(ExpensesClaimRepository expensesClaimRepository) {
    this.expensesClaimRepository = expensesClaimRepository;
  }

  @Override
  public ExpensesClaim createExpensesClaim(ExpensesClaim expensesClaim) {
    return expensesClaimRepository.save(expensesClaim);
  }

  @Override
  public ExpensesClaim getExpensesClaim(Long id) {
    Optional<ExpensesClaim> expensesClaimOptional = expensesClaimRepository.findById(id);
    if (expensesClaimOptional.isPresent()) {
      return expensesClaimOptional.get();
    } else {
      throw new ExpensesClaimNotFoundException(id);
    }
  }

  @Override
  public List<ExpensesClaim> getAllExpensesClaims() {
    return expensesClaimRepository.findAll();
  }

  @Override
  public ExpensesClaim updateExpensesClaim(Long id, ExpensesClaim expensesClaim) {
    Optional<ExpensesClaim> expensesClaimOptional = expensesClaimRepository.findById(id);
    if (expensesClaimOptional.isPresent()) {
      ExpensesClaim existingExpensesClaim = expensesClaimOptional.get();
      existingExpensesClaim.setCreatedDate(expensesClaim.getCreatedDate());
      existingExpensesClaim.setAmount(expensesClaim.getAmount());
      existingExpensesClaim.setApprovedBySupervisor(expensesClaim.getApprovedBySupervisor());
      existingExpensesClaim.setApprovedDateTimeSupervisor(expensesClaim.getApprovedDateTimeSupervisor());
      existingExpensesClaim.setApprovedByHOD(expensesClaim.getApprovedByHOD());
      existingExpensesClaim.setApprovedDateTimeHOD(expensesClaim.getApprovedDateTimeHOD());
      existingExpensesClaim.setCreatedBy(expensesClaim.getCreatedBy());
      existingExpensesClaim.setTypeOfClaim(expensesClaim.getTypeOfClaim());
      existingExpensesClaim.setRemarks(expensesClaim.getRemarks());
      existingExpensesClaim.setPersonRejected(expensesClaim.getPersonRejected());
      return expensesClaimRepository.save(existingExpensesClaim);
    } else {
      throw new ExpensesClaimNotFoundException(id);
    }
  }

  @Override
  public void deleteExpensesClaim(Long id) {
    if (expensesClaimRepository.existsById(id)) {
      expensesClaimRepository.deleteById(id);
    } else {
      throw new ExpensesClaimNotFoundException(id);
    }
  }
}
