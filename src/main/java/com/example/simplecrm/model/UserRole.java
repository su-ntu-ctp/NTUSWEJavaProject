package com.example.simplecrm.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "uid")
  private Long uid;

  @Column(name = "role_name")
  private String roleName;

  private String department;

  public UserRole() {
  }

  public UserRole(Long uid, String roleName, String department) {
    this.uid = uid;
    this.roleName = roleName;
    this.department = department;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "UserRole{" +
        "id=" + id +
        ", uid=" + uid +
        ", roleName='" + roleName + '\'' +
        ", department='" + department + '\'' +
        '}';
  }
}
