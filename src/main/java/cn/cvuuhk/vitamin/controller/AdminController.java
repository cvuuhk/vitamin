package cn.cvuuhk.vitamin.controller;

import cn.cvuuhk.vitamin.entity.Admin;
import cn.cvuuhk.vitamin.entity.Status;
import cn.cvuuhk.vitamin.service.AdminService;
import cn.cvuuhk.vitamin.service.UserService;
import cn.cvuuhk.vitamin.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Resource UserService userService;
  @Resource AdminService adminService;

  @GetMapping("/info")
  public ResultVO<Admin> info() {
    String id = userService.getCurrentUser().getId();
    return new ResultVO<>(adminService.getAdmin(id));
  }

  @GetMapping("/status")
  public ResultVO<List<Status>> allStatus() {
    return new ResultVO<>(adminService.getAllStatus());
  }

  @PostMapping("/status")
  public ResultVO<Status> changeStatus(@RequestBody String id) {
    return new ResultVO<>(adminService.changeStatusTo(id));
  }
}
