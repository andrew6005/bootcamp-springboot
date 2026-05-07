package com.bootcampspring.demo_call_api.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcampspring.demo_call_api.model.UserDto;


@Service
public class ForumService {
//https://jsonplaceholder.typicode.com/users
  public List<UserDto> getUsers() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";
    // ! Deserialization (反序列化) - List = Array (json -> [])
    // Json String -> Java Object (List or Object)
    UserDto[] userDtos = restTemplate.getForObject(url, UserDto[].class); // RestFul GET
    return Arrays.asList(userDtos);
  }
  public List<UserDto> getUsers2() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";
    // ! Deserialization (反序列化) - List = Array (json -> [])
    // Json String -> Java Object (List or Object)
    UserDto[] userDtos = restTemplate.getForObject(url, UserDto[].class); // RestFul GET
    return Arrays.asList(userDtos);
  }

  

}