package com.kbs.blog.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kbs.blog.model.EntityTest;
import com.kbs.blog.repository.EntityTestRepository;

@RestController
public class AnythingTestController {

  @Autowired
  EntityTestRepository entityTestRepository;
  
  
  @GetMapping("/anything")
  public void testAny() {
    
    EntityTest rtn = entityTestRepository.findById(1).get();
    
    System.out.println(rtn.getTime());
    
    LocalDateTime time = rtn.getTime();
    System.out.println(time.getYear());
    System.out.println(time.getMonth());
    System.out.println(time.getMonthValue());
    System.out.println(time.getDayOfMonth());
    System.out.println(time.getHour());
    System.out.println(time.getMinute());
    System.out.println(time.getSecond());
    
    System.out.println(time.format(DateTimeFormatter.ofPattern("yyyyMMdd24HHmmss")));
    
    
    
  }
  
  @GetMapping("/entity")
  public List<EntityTest> test() {
    
    List<EntityTest> result = entityTestRepository.findAll();
    
   
    System.out.println(result);
    
    return result;
  }
  
  @PostMapping("/entity")
  public String testSave(String name) {
    
    LocalDateTime time = LocalDateTime.of(2021, 9, 12, 14, 25);
    
    entityTestRepository.save(EntityTest.builder().name(name).time(time).build());
    
    return "OK";
  }
  
  
}
