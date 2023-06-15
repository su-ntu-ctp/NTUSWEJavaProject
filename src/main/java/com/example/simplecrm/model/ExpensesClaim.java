package com.example.simplecrm.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_claims")
public class ExpensesClaim {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "expense_id")
  private int expenseId;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  private double amount;

  @Column(name = "approved_by_supervisor")
  private String approvedBySupervisor;

  @Column(name = "approved_date_time_supervisor")
  private LocalDateTime approvedDateTimeSupervisor;

  @Column(name = "approved_by_hod")
  private String approvedByHOD;

  @Column(name = "approved_date_time_hod")
  private LocalDateTime approvedDateTimeHOD;

  @Column(name = "created_by")
  private Long createdBy;

  @Column(name = "type_of_claim")
  private String typeOfClaim;

  private String remarks;

  @Column(name = "person_rejected")
  private String personRejected;

  public ExpensesClaim() {
  }

  public ExpensesClaim(LocalDateTime createdDate, double amount, String approvedBySupervisor,
      LocalDateTime approvedDateTimeSupervisor,
      String approvedByHOD, LocalDateTime approvedDateTimeHOD, Long createdBy, String typeOfClaim, String remarks,
      String personRejected) {
    this.createdDate = createdDate;
    this.amount = amount;
    this.approvedBySupervisor = approvedBySupervisor;
    this.approvedDateTimeSupervisor = approvedDateTimeSupervisor;
    this.approvedByHOD = approvedByHOD;
    this.approvedDateTimeHOD = approvedDateTimeHOD;
    this.createdBy = createdBy;
    this.typeOfClaim = typeOfClaim;
    this.remarks = remarks;
    this.personRejected = personRejected;
  }

  public int getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(int expenseId) {
    this.expenseId = expenseId;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getApprovedBySupervisor() {
    return approvedBySupervisor;
  }

  public void setApprovedBySupervisor(String approvedBySupervisor) {
    this.approvedBySupervisor = approvedBySupervisor;
  }

  public LocalDateTime getApprovedDateTimeSupervisor() {
    return approvedDateTimeSupervisor;
  }

  public void setApprovedDateTimeSupervisor(LocalDateTime approvedDateTimeSupervisor) {
    this.approvedDateTimeSupervisor = approvedDateTimeSupervisor;
  }

  public String getApprovedByHOD() {
    return approvedByHOD;
  }

  public void setApprovedByHOD(String approvedByHOD) {
    this.approvedByHOD = approvedByHOD;
  }

  public LocalDateTime getApprovedDateTimeHOD() {
    return approvedDateTimeHOD;
  }

  public void setApprovedDateTimeHOD(LocalDateTime approvedDateTimeHOD) {
    this.approvedDateTimeHOD = approvedDateTimeHOD;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  public String getTypeOfClaim() {
    return typeOfClaim;
  }

  public void setTypeOfClaim(String typeOfClaim) {
    this.typeOfClaim = typeOfClaim;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getPersonRejected() {
    return personRejected;
  }

  public void setPersonRejected(String personRejected) {
    this.personRejected = personRejected;
  }
}
