package cn.cvuuhk.vitamin.vo;

public enum Result {
  SUCCESS(1000, "success"),
  FAILED(1001, "failed"),
  VALIDATE_FAILED(1002, "参数校验失败");

  private final Integer code;
  private final String msg;

  Result(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
