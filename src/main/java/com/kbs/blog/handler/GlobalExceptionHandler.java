package com.kbs.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  @ExceptionHandler(value = IllegalArgumentException.class)
  public String handleArgumentException(IllegalArgumentException e) {
    return String.format("<h1>%s</h1>", e.getMessage());
  }
  
  @ExceptionHandler(value = Exception.class)
  public String handleArgumentException(Exception e) {
    return String.format("<h2 style='color:red'>%s</h2>", e.getMessage());
  }
}
