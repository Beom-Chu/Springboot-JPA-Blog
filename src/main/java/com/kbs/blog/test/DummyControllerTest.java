package com.kbs.blog.test;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kbs.blog.model.RoleType;
import com.kbs.blog.model.User;
import com.kbs.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dummy")
public class DummyControllerTest {

  private UserRepository userRepository;

  @Autowired
  DummyControllerTest(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @GetMapping("/user/{id}")
  public User detail(@PathVariable int id) {

    log.info("detail - id :{}", id);
    // User user = userRepository.findById(id).get();
    // User user = userRepository.findById(id).orElseGet(() -> new User()); // 조회값이 없을시 빈 객체

    User user =
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회 결과가 없습니다. id="+id));

    return user;
  }

  @GetMapping("/user/username")
  public List<User> findUsername(@RequestParam String username) {
    return userRepository.findByUsername(username);
  }
  

  @GetMapping("/users")
  public List<User> list() {
    return userRepository.findAll();
  }


  @GetMapping("/user")
  public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

    Page<User> pagingUser = userRepository.findAll(pageable);
    List<User> users = pagingUser.getContent();
    
    return users;
  }


  @PostMapping("/join")
  public String join(@RequestBody User user) {
    System.out.println(user.toString());

    user.setRole(RoleType.USER);

    userRepository.save(user);

    return "회원 가입이 완료되었습니다.";
  }
  
  @Transactional
  @PutMapping("/user/{id}")
  public String updateUser(@PathVariable int id, @RequestBody User requestUser) {

    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회 결과가 없습니다. id="+id));

    user.setEmail(requestUser.getEmail());
    user.setPassword(requestUser.getPassword());

    return "수정이 완료 되었습니다.";
  }
  
  @DeleteMapping("/user/delete/{id}")
  public String delete(@PathVariable int id) {
    try {
      userRepository.deleteById(id);
    }catch (EmptyResultDataAccessException e) {
      return "삭제 실패. 삭제 대상이 존재하지 않습니다.";
    }
    return "삭제 되었습니다.";
  }
}
