package com.bootcampspring.demo_call_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcampspring.demo_call_api.entity.AddressEntity;
import com.bootcampspring.demo_call_api.entity.CompanyEntity;
import com.bootcampspring.demo_call_api.entity.GeoEntity;
import com.bootcampspring.demo_call_api.entity.UserEntity;
import com.bootcampspring.demo_call_api.model.UserDto;
import com.bootcampspring.demo_call_api.repository.AddressRepository;
import com.bootcampspring.demo_call_api.repository.CompanyRepository;
import com.bootcampspring.demo_call_api.repository.GeoRepository;
import com.bootcampspring.demo_call_api.repository.UserRepository;

@Service
public class ForumService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private GeoRepository geoRepository;

  public List<UserDto> getUsers() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDto[] userDtos = restTemplate.getForObject(url, UserDto[].class);
    return Arrays.asList(userDtos);
  }

  public List<UserEntity> insertUsers() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDto[] userDtos = restTemplate.getForObject(url, UserDto[].class);

    this.geoRepository.deleteAll();
    this.addressRepository.deleteAll();
    this.companyRepository.deleteAll();
    this.userRepository.deleteAll();

    List<UserEntity> userEntities = new ArrayList<>();

    for (UserDto dto : userDtos) {
      UserEntity userEntity = new UserEntity();
      userEntity.setUsername(dto.getUsername());
      userEntity.setName(dto.getName());
      userEntity.setEmail(dto.getEmail());
      userEntity.setPhone(dto.getPhone());
      userEntity.setWebsite(dto.getWebsite());

      AddressEntity addressEntity = new AddressEntity();
      addressEntity.setStreet(dto.getAddressDto().getStreet());
      addressEntity.setSuite(dto.getAddressDto().getSuite());
      addressEntity.setCity(dto.getAddressDto().getCity());
      addressEntity.setZipcode(dto.getAddressDto().getZipcode());
      addressEntity.setUserEntity(userEntity);

      GeoEntity geoEntity = new GeoEntity();
      geoEntity.setLatitude(Double.valueOf(dto.getAddressDto().getGeoDto().getLat()));
      geoEntity.setLongitude(Double.valueOf(dto.getAddressDto().getGeoDto().getLng()));
      geoEntity.setAddressEntity(addressEntity);

      CompanyEntity companyEntity = new CompanyEntity();
      companyEntity.setName(dto.getCompanyDto().getName());
      companyEntity.setCatchPhrase(dto.getCompanyDto().getCatchPhrase());
      companyEntity.setBs(dto.getCompanyDto().getBs());
      companyEntity.setUserEntity(userEntity);

      this.userRepository.save(userEntity);
      this.addressRepository.save(addressEntity);
      this.companyRepository.save(companyEntity);
      this.geoRepository.save(geoEntity);

      userEntities.add(userEntity);
    }

    return userEntities;
  }
}
