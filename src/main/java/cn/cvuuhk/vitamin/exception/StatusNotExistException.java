package cn.cvuuhk.vitamin.exception;

public class StatusNotExistException extends RuntimeException {
  public StatusNotExistException() {
    super("该状态不存在");
  }
}
