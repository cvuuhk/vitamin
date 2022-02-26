package cn.cvuuhk.vitamin.exception;

public class NotLoginException extends RuntimeException {
  public NotLoginException() {
    super("用户未登录");
  }
}
