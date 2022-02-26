package cn.cvuuhk.vitamin.controller;

import cn.cvuuhk.vitamin.context.RequestContext;
import cn.cvuuhk.vitamin.entity.Course;
import cn.cvuuhk.vitamin.entity.Status;
import cn.cvuuhk.vitamin.entity.User;
import cn.cvuuhk.vitamin.service.CourseService;
import cn.cvuuhk.vitamin.service.UserService;
import cn.cvuuhk.vitamin.service.VitaminService;
import cn.cvuuhk.vitamin.vo.LoginVO;
import cn.cvuuhk.vitamin.vo.Result;
import cn.cvuuhk.vitamin.vo.ResultVO;
import cn.cvuuhk.vitamin.vo.SimpleCourseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class GeneralController {
  @Resource UserService userService;
  @Resource CourseService courseService;
  @Resource VitaminService vitaminService;

  @PostMapping("/login")
  public ResultVO<User> login(@RequestBody @Valid LoginVO vo) {
    if (!userService.login(vo.getUserId(), vo.getPassword()))
      return new ResultVO<>(Result.FAILED, null);
    RequestContext.getCurrentRequest().getSession().setAttribute("login", vo);
    return new ResultVO<>(userService.getUserById(vo.getUserId()));
  }

  @PostMapping("/logout")
  public ResultVO<String> logout() {
    RequestContext.getCurrentRequest().getSession().removeAttribute("login");
    return new ResultVO<>("注销成功");
  }

  @GetMapping("/course")
  public ResultVO<Set<SimpleCourseVO>> courses() {
    return new ResultVO<>(
        courseService.all().stream().map(SimpleCourseVO::new).collect(Collectors.toSet()));
  }

  @GetMapping("/course/{id}")
  public ResultVO<Course> course(@PathVariable String id) {
    return new ResultVO<>(courseService.getCourse(id));
  }

  @GetMapping("/status")
  public ResultVO<Status> status() {

    return new ResultVO<>(vitaminService.getCurrent().getStatus());
  }
}
