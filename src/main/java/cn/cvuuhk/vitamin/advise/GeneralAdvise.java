package cn.cvuuhk.vitamin.advise;

import cn.cvuuhk.vitamin.exception.CourseNotExistException;
import cn.cvuuhk.vitamin.exception.LoginFailedException;
import cn.cvuuhk.vitamin.exception.NotLoginException;
import cn.cvuuhk.vitamin.vo.Result;
import cn.cvuuhk.vitamin.vo.ResultVO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralAdvise {

  @ExceptionHandler(NotLoginException.class)
  public ResultVO<String> notLoginExceptionHandler(NotLoginException e) {
    return new ResultVO<>(Result.FAILED, e.getMessage());
  }

  @ExceptionHandler(LoginFailedException.class)
  public ResultVO<String> loginFailedExceptionHandler(LoginFailedException e) {
    return new ResultVO<>(Result.FAILED, e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResultVO<String> methodArgumentNotValidExceptionHandler(
      MethodArgumentNotValidException e) {
    String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    return new ResultVO<>(Result.VALIDATE_FAILED, msg);
  }

  @ExceptionHandler(CourseNotExistException.class)
  public ResultVO<String> courseNotExistExceptionHandler(CourseNotExistException e) {
    return new ResultVO<>(Result.FAILED, e.getMessage());
  }
}
