package com.demo.helloeworld.demohellowworld;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import jakarta.websocket.server.PathParam;





@RestController
public class HelloworldController {
   
   @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye"; 
    }
  @GetMapping(value = "/person/name{name}/age/{age}")
  public String createPerson(@PathParam(value = "name")String name,
    @PathVariable Integer age){
    return name +"_"+age;
  }


}
