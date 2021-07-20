package com.kbs.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kbs.blog.dto.ResponseDto;
import com.kbs.blog.model.RoleType;
import com.kbs.blog.model.User;
import com.kbs.blog.service.UserService;

@RestController
public class UserApiController {

  private final UserService userService;

  @Autowired
  public UserApiController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/api/user")
  public ResponseDto<Integer> save(@RequestBody User user) {

    System.out.println("api/user");

    user.setRole(RoleType.USER);
    int result = userService.회원가입(user);

    return new ResponseDto<Integer>(HttpStatus.OK, result);
  }
}
