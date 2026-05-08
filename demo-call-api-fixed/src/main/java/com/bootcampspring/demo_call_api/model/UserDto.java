package com.bootcampspring.demo_call_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
  private Long id;
  private String name;
  private String username;
  private String email;

  @JsonProperty(value = "address")
  private AddressDto addressDto;

  private String phone;
  private String website;

  @JsonProperty(value = "company")
  private CompanyDto companyDto;

  public UserDto() {
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AddressDto getAddressDto() {
    return addressDto;
  }

  public void setAddressDto(AddressDto addressDto) {
    this.addressDto = addressDto;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public CompanyDto getCompanyDto() {
    return companyDto;
  }

  public void setCompanyDto(CompanyDto companyDto) {
    this.companyDto = companyDto;
  }

  public static class AddressDto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @JsonProperty(value = "geo")
    private GeoDto geoDto;

    public AddressDto() {
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getSuite() {
      return suite;
    }

    public void setSuite(String suite) {
      this.suite = suite;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getZipcode() {
      return zipcode;
    }

    public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
    }

    public GeoDto getGeoDto() {
      return geoDto;
    }

    public void setGeoDto(GeoDto geoDto) {
      this.geoDto = geoDto;
    }
  }

  public static class GeoDto {
    private String lat;
    private String lng;

    public GeoDto() {
    }

    public String getLat() {
      return lat;
    }

    public void setLat(String lat) {
      this.lat = lat;
    }

    public String getLng() {
      return lng;
    }

    public void setLng(String lng) {
      this.lng = lng;
    }
  }

  public static class CompanyDto {
    private String name;
    private String catchPhrase;
    private String bs;

    public CompanyDto() {
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
  }
}
