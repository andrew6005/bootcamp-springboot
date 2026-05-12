package com.bootcamp.bcforum.dto;

import com.bootcamp.bcforum.entity.UserEntity.Address;
import com.bootcamp.bcforum.entity.UserEntity.Company;
import java.util.List;

public record UserDto(
    Integer id,
    String name,
    String username,
    String email,
    Address address,
    String phone,
    String website,
    Company company,
    List<PostDto> posts) {
}
