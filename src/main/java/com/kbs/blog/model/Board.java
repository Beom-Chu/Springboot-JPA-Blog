package com.kbs.blog.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, length = 100)
  private String title;

  @Lob
  private String content;

  @ColumnDefault("0")
  private int count;

  @ManyToOne(fetch = FetchType.EAGER) //@ManyToOne 기본 : fetch = FetchType.EAGER : 즉시로딩
  @JoinColumn(name = "userId")
  private User user;

  @OneToMany(mappedBy = "board") //@OneToMany기본 : fetch = FetchType.LAZY : 지연로딩
  private List<Reply> reply;

  @CreationTimestamp
  private Timestamp createDate;
}
