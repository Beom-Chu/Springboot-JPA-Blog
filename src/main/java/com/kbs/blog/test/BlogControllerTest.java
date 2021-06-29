package com.kbs.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
public class BlogControllerTest {

  @GetMapping("/hello")
  @ApiOperation(value="테스트 Hello", notes="테스트로 Hello를 반환한다.")
  public String hello() {
    return "<h1>hello spring boot!</h1>";
  }
  
  @GetMapping("/hello2")
  @ApiOperation(value="테스트 Hello2", notes="테스트로 안녕하십니까를 반환한다.")
  public String hello2() {
    return "안녕하십니까~";
  }
}
