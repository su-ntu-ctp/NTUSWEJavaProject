package com.example.simplecrm.model;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "loginid")
  private String loginId;

  private String password;

  @Column(name = "jwt_token")
  private String jwtToken;

  public Login() {
  }

  public Login(String loginId, String password, String jwtToken) {
    this.loginId = loginId;
    this.password = password;
    this.jwtToken = jwtToken;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }
}
