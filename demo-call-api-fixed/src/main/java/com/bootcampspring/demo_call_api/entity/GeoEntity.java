package com.bootcampspring.demo_call_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "geos")
public class GeoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double latitude;
  private Double longitude;

  @OneToOne
  @JoinColumn(name = "address_id")
  private AddressEntity addressEntity;

  public GeoEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public AddressEntity getAddressEntity() {
    return addressEntity;
  }

  public void setAddressEntity(AddressEntity addressEntity) {
    this.addressEntity = addressEntity;
  }
}
