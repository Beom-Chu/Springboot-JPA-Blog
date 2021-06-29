package com.kbs.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/http")
public class HttpControllerTest {

  @GetMapping("/get")
  @ApiOperation(value = "http get", notes = "http get test.")
  public String getTest(Member m) {
    return String.format("get 요청 : %s, %s", m.getId(), m.getUsername());
  }

  @PostMapping("/post")
  @ApiOperation(value = "http post", notes = "http post test.")
  public String postTest(Member m) {
    return String.format("post 요청 : %s, %s, %s, %s", m.getId(), m.getUsername(), m.getEmail(),
        m.getPassword());
  }

  @PutMapping("/put")
  @ApiOperation(value = "http put", notes = "http put test.")
  public String putTest() {
    return "put 요청";
  }

  @DeleteMapping("/delete")
  @ApiOperation(value = "http delete", notes = "http delete test.")
  public String deleteTest() {
    return "delete 요청";
  }
}
