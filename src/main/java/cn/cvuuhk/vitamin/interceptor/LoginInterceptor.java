package cn.cvuuhk.vitamin.interceptor;

import cn.cvuuhk.vitamin.exception.NotLoginException;
import cn.cvuuhk.vitamin.vo.LoginVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String uri = request.getRequestURI();
    if (uri.equals("/login") || uri.equals("/logout")) return true;

    LoginVO vo = (LoginVO) request.getSession().getAttribute("login");
    if (vo == null) throw new NotLoginException();

    return true;
  }
}
