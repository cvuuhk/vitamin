package cn.cvuuhk.vitamin.context;

import cn.cvuuhk.vitamin.vo.LoginVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestContext {

  public static HttpServletRequest getCurrentRequest() {
    return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
        .getRequest();
  }

  public static String getCurrentUserId() {
    LoginVO vo = (LoginVO) getCurrentRequest().getSession().getAttribute("login");
    return vo.getUserId();
  }
}
