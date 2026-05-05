package com.demorestful.demo_restful_api;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Repository

public class NameController {

  @GetMapping("/names")
  public List<Name> getNames() {
    return MemoryDatabase.names;
  }

  @PostMapping("/name")
  public Name addName(@RequestBody Name name) {
    MemoryDatabase.names.add(name);
    return name;
  }

  @GetMapping("/name")
  public List<Name> getName(@RequestParam String lastName) {
    return MemoryDatabase.names.stream()
        .filter(e -> lastName.equals(e.getLastName()))
        .collect(Collectors.toList());
  }

  //update

  //delete
  @DeleteMapping(value = "/name/{lastname}")
  public Boolean deleteByLastName(@PathVariable String lastName){
    return MemoryDatabase.names.removeIf(e-> lastName.equals(e.getLastName()));
  }
//update

@PutMapping(value = "/name/{id}")
public Name updatName(@PathVariable Long id ,@RequestBody Name newName){
  for(int i =0;i<MemoryDatabase.names.size();i++){
    if(id.equals(MemoryDatabase.names.get(i).getId())){
      newName.setId(id);
      MemoryDatabase.names.set(i,newName);
    }

  } 
  return newName;
}

  
}