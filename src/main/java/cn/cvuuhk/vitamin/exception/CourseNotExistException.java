package cn.cvuuhk.vitamin.exception;

public class CourseNotExistException extends RuntimeException {
  public CourseNotExistException(String message) {
    super(message);
  }
}
