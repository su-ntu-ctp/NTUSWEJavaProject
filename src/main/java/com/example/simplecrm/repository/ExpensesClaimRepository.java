package com.example.simplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.simplecrm.model.ExpensesClaim;

public interface ExpensesClaimRepository extends JpaRepository<ExpensesClaim, Long> {

}