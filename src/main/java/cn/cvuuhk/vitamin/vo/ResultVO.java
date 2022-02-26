package cn.cvuuhk.vitamin.vo;

public class ResultVO<T> {
  private Integer code;
  private String msg;
  private T data;

  public ResultVO(Result result, T data) {
    this.code = result.getCode();
    this.msg = result.getMsg();
    this.data = data;
  }

  public ResultVO(T data) {
    this(Result.SUCCESS, data);
  }

  public Integer getCode() {
    return code;
  }

  public ResultVO<T> setCode(Integer code) {
    this.code = code;
    return this;
  }

  public String getMsg() {
    return msg;
  }

  public ResultVO<T> setMsg(String msg) {
    this.msg = msg;
    return this;
  }

  public T getData() {
    return data;
  }

  public ResultVO<T> setData(T data) {
    this.data = data;
    return this;
  }
}
