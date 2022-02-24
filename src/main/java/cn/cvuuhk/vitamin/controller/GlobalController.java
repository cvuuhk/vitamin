package cn.cvuuhk.vitamin.controller;

import cn.cvuuhk.vitamin.context.RequestContext;
import cn.cvuuhk.vitamin.service.UserService;
import cn.cvuuhk.vitamin.vo.LoginVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class GlobalController {
  @Resource UserService service;

  @PostMapping("/login")
  public String login(@RequestBody @Valid LoginVO vo) {
    if (!service.login(vo.getUserId(), vo.getPassword())) return "登录失败";
    RequestContext.getCurrentRequest().getSession().setAttribute("login", vo);

    return "登录成功";
  }

  @PostMapping("/logout")
  public String logout() {
    RequestContext.getCurrentRequest().getSession().removeAttribute("login");
    return "注销成功";
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}
