package com.kbs.blog.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kbs.blog.model.User;
import com.kbs.blog.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public int 회원가입(User user) {

    try {
      userRepository.save(user);
      return 1;
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("UserService:회원가입():" + e.getMessage());
    }

    return -1;
  }
}
