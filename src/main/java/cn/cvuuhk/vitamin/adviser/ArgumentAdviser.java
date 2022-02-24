package cn.cvuuhk.vitamin.adviser;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArgumentAdviser {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public String methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    return e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
  }
}
