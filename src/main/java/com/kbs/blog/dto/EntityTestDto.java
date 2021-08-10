package com.kbs.blog.dto;

import java.time.format.DateTimeFormatter;
import com.kbs.blog.model.EntityTest;
import lombok.Getter;

@Getter
public class EntityTestDto {
  
  private String name;

  private String regTimeStr;

  private String inputTimeStr;
  
  public EntityTestDto(EntityTest entityTest) {
    this.name = entityTest.getName();
    this.regTimeStr = entityTest.getRegTime()==null?"":entityTest.getRegTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    this.inputTimeStr = entityTest.getInputTime()==null?"":entityTest.getInputTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
