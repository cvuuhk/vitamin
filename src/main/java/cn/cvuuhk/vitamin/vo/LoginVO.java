package cn.cvuuhk.vitamin.vo;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class LoginVO {
  @NotBlank(message = "账户不能为空！")
  private String userId;

  @NotBlank(message = "密码不能为空！")
  @Length(min = 4, max = 16, message = "密码长度必须是 4～16 个字符")
  private String password;

  public String getUserId() {
    return userId;
  }

  public LoginVO setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public LoginVO setPassword(String password) {
    this.password = password;
    return this;
  }
}
