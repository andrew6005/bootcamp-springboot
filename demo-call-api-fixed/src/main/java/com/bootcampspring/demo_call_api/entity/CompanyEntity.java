package com.bootcampspring.demo_call_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100)
  private String name;

  @Column(name = "catch_phrase", length = 230)
  private String catchPhrase;

  @Column(length = 230)
  private String bs;

  @OneToOne
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;

  public CompanyEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCatchPhrase() {
    return catchPhrase;
  }

  public void setCatchPhrase(String catchPhrase) {
    this.catchPhrase = catchPhrase;
  }

  public String getBs() {
    return bs;
  }

  public void setBs(String bs) {
    this.bs = bs;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
  }
}
