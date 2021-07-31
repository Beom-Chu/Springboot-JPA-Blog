package com.kbs.blog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kbs.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

  List<User> findByUsername(String username);
  
  User findByUsernameAndPassword(String username, String password);
  
  @Query(value = "SELECT * FROM User WHERE username = ?1 AND password = ?2" , nativeQuery = true)
  User login(String username, String password);
  
}
