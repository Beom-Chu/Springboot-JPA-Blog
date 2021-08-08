package com.kbs.blog.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Reply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 200)
  private String content;

  @ManyToOne
  @JoinColumn(name = "boardId")
  private Board board;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  @CreationTimestamp
  private Timestamp createDate;
  
  
  /* 연관관계 편의 메소드 */
  public void changeBoard(Board board) {
    if(this.board != null) {
      this.board.getReply().remove(this);
    }
    
    this.board = board;
    board.getReply().add(this);
  }
}
