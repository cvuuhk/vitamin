package cn.cvuuhk.vitamin.adviser;

import cn.cvuuhk.vitamin.exception.LoginFailedException;
import cn.cvuuhk.vitamin.exception.NotLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LoginAdviser {
  @ExceptionHandler(NotLoginException.class)
  public String notLoginExceptionHandler(NotLoginException e) {
    return e.getMessage();
  }

  @ExceptionHandler(LoginFailedException.class)
  public String loginFailedExceptionHandler(LoginFailedException e) {
    return e.getMessage();
  }
}
