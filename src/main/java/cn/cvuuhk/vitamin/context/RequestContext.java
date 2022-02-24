package cn.cvuuhk.vitamin.context;

import cn.cvuuhk.vitamin.entity.User;
import cn.cvuuhk.vitamin.service.UserService;
import cn.cvuuhk.vitamin.vo.LoginVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class RequestContext {
  @Resource private static UserService service;

  public static HttpServletRequest getCurrentRequest() {
    return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
        .getRequest();
  }

  public static User getCurrentUser() {
    LoginVO vo = (LoginVO) getCurrentRequest().getSession().getAttribute("login");
    return service.getUserById(vo.getUserId());
  }
}
