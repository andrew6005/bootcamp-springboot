package com.bootcamp.bcforum.dto;

import java.util.List;

public record UserDto(
    Integer id,
    String name,
    String username,
    String email,
    AddressDto address,
    String phone,
    String website,
    CompanyDto company,
    List<PostDto> posts) {
}
