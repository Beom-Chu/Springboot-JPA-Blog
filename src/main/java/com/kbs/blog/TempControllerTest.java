package com.kbs.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

  @GetMapping("/testjsp")
  public String tempJsp() {
    
    return "test";
  }
}
