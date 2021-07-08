package com.kbs.blog;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.kbs.blog.model.Board;
import com.kbs.blog.model.Reply;
import com.kbs.blog.model.User;

@Controller
public class TempControllerTest {

  @GetMapping("/testjsp")
  public String tempJsp() {
    
    User user = User.builder().build();
    
    System.out.println(user.toString());
    
    Board board = Board.builder().build();
    
    List<Reply> r = board.getReply();
    
    return "test";
  }
}
