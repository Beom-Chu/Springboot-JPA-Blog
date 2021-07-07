package com.kbs.blog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kbs.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

  List<User> findByUsername(String username);
  
}
