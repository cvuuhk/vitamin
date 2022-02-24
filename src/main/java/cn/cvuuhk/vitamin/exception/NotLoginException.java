package cn.cvuuhk.vitamin.exception;

import org.springframework.stereotype.Component;

public class NotLoginException extends RuntimeException {
  public NotLoginException() {
    super("用户未登录");
  }
}
