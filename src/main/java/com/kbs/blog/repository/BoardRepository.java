package com.kbs.blog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kbs.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

  
  // 페치 조인 연관 관계의 데이터 한번에 조회 (n+1 예방)
  @Query(value = "select b from Board b join fetch b.user")
  List<Board> findByAllFetch();
}
