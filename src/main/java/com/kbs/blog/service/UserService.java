package com.kbs.blog.service;

import javax.annotation.PostConstruct;
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
  
  @PostConstruct /* was 구동시 실행 */
  public void init() {
//    userRepository.save(User.builder().username("test").password("1234").email("test1234@abcd.com").build());
    
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
