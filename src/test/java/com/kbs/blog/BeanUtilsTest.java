package com.kbs.blog;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import lombok.Data;

public class BeanUtilsTest {

  @Test
  public void test() {
    StudentInfo st = new StudentInfo();
    st.setName("홍길동");
    st.setGrade(1);
    st.setNumber(2);
    st.setTime(Timestamp.valueOf(LocalDateTime.now()));
    StudentInfoTarget stTarget = new StudentInfoTarget();
    BeanUtils.copyProperties(st, stTarget); // StudentInfoTarget(name=홍길동, grade=2, number=15)
    
    System.out.println(st);
    System.out.println(stTarget);
  }

  @Data
  class StudentInfo {
    private String name;
    private int grade;
    private int number;
    private Timestamp time;
  }

  @Data
  class StudentInfoTarget {
    private String name;
    private int grade;
    private String number;
    private String time;
    
    public void setNumber(int number) {
      this.number = String.valueOf(number);
    }
    
    public void setTime(Timestamp time) {
      this.time = String.valueOf(time);
    }
  }
}
