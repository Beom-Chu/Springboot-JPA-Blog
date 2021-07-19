package com.kbs.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kbs.blog.dto.ResponseDto;
import com.kbs.blog.model.User;

@RestController
public class UserApiController {

  @PostMapping("/api/user")
  public ResponseDto<Integer> save(@RequestBody User user) {
    
    System.out.println("api/user");
    
    return new ResponseDto<Integer>(HttpStatus.OK, 1);
  }
}
