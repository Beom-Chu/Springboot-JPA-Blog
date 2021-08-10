package com.kbs.blog.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EntityTest {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(length = 30)
  private String name;
  
  @CreationTimestamp
  private LocalDateTime regTime;
  
  private LocalDateTime inputTime;
  
  @Enumerated(EnumType.STRING)
  @Column(length = 30)
  private RoleType roleType;
  
  @Column(length = 150)
  private String fileName;
  
  @Column(length = 150)
  private String fileUniqueName;
  
  @Column(length = 150)
  private String filePath;
}
