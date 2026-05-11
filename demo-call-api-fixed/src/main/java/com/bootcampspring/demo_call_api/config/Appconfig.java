package main.java.com.bootcampspring.demo_call_api.config;

import java.beans.BeanProperty;

@Configuration

public class Appconfig {
  @Bean
  RestTemplate restTemplate;{
    return new RestTemplate();
  }
}
