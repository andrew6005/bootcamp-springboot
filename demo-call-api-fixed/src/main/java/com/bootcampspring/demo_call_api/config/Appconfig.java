package main.java.com.bootcampspring.demo_call_api.config;

import java.beans.BeanProperty;

@Configuration
//! Configuration -> built in java ->Bean
public class Appconfig {
  @Bean
  RestTemplate restTemplate;{
    return new RestTemplate();
  }
}
