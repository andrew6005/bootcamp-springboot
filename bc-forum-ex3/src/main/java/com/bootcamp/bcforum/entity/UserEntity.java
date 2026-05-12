package com.bootcamp.bcforum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  private Integer id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String lat;
  private String lng;
  private String companyName;
  private String catchPhrase;

  @Column(length = 1000)
  private String bs;

  public UserEntity() {
  }

  public UserEntity(Integer id, String name, String username, String email, String phone,
      String website, String street, String suite, String city, String zipcode, String lat,
      String lng, String companyName, String catchPhrase, String bs) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.website = website;
    this.street = street;
    this.suite = suite;
    this.city = city;
    this.zipcode = zipcode;
    this.lat = lat;
    this.lng = lng;
    this.companyName = companyName;
    this.catchPhrase = catchPhrase;
    this.bs = bs;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getWebsite() {
    return website;
  }

  public String getStreet() {
    return street;
  }

  public String getSuite() {
    return suite;
  }

  public String getCity() {
    return city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public String getLat() {
    return lat;
  }

  public String getLng() {
    return lng;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getCatchPhrase() {
    return catchPhrase;
  }

  public String getBs() {
    return bs;
  }
}
