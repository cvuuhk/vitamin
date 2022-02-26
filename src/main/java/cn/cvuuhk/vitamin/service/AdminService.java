package cn.cvuuhk.vitamin.service;

import cn.cvuuhk.vitamin.dao.AdminRepository;
import cn.cvuuhk.vitamin.dao.StatusRepository;
import cn.cvuuhk.vitamin.dao.VitaminSystemRepository;
import cn.cvuuhk.vitamin.entity.Admin;
import cn.cvuuhk.vitamin.entity.Status;
import cn.cvuuhk.vitamin.entity.VitaminSystem;
import cn.cvuuhk.vitamin.exception.StatusNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

  @Resource VitaminSystemRepository vitaminSystemRepository;
  @Resource AdminRepository adminRepository;
  @Resource StatusRepository statusRepository;

  @Transactional
  public List<Status> getAllStatus() {
    return statusRepository.findAll();
  }

  @Transactional
  public Admin getAdmin(String id) {
    return adminRepository.findById(id).get();
  }

  @Transactional
  public Status changeStatusTo(String statusId) {
    Status target =
        statusRepository.findById(statusId).orElseThrow(() -> new StatusNotExistException());
    VitaminSystem current = vitaminSystemRepository.findById("1").get();
    current.setStatus(target);
    return target;
  }
}
