package com.kbs.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
  public void 회원가입(User user) {

    userRepository.save(user);

  }

  @Transactional(readOnly = true)
  public User 로그인(User user) {
    return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    return userRepository.login(user.getUsername(), user.getPassword());
  }
}
