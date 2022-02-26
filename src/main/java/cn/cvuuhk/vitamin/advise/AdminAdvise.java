package cn.cvuuhk.vitamin.advise;

import cn.cvuuhk.vitamin.exception.StatusNotExistException;
import cn.cvuuhk.vitamin.vo.Result;
import cn.cvuuhk.vitamin.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminAdvise {
  @ExceptionHandler(StatusNotExistException.class)
  public ResultVO<String> statusNotExistExceptionHandler(StatusNotExistException e) {
    return new ResultVO<>(Result.FAILED, e.getMessage());
  }
}
