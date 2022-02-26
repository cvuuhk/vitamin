package cn.cvuuhk.vitamin.service;

import cn.cvuuhk.vitamin.dao.StatusRepository;
import cn.cvuuhk.vitamin.dao.VitaminSystemRepository;
import cn.cvuuhk.vitamin.entity.Status;
import cn.cvuuhk.vitamin.entity.VitaminSystem;
import cn.cvuuhk.vitamin.exception.StatusNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VitaminService {
  @Resource VitaminSystemRepository repository;
  @Resource StatusRepository statusRepository;

  @Transactional
  public List<Status> all() {
    return statusRepository.findAll();
  }

  @Transactional
  public VitaminSystem getCurrent() {
    return repository.findById("1").get();
  }

  @Transactional
  public void setStatus(String statusId) {
    Status status =
        statusRepository
            .findById(statusId)
            .orElseThrow(() -> new StatusNotExistException());
    VitaminSystem current = repository.findById("1").get();
    current.setStatus(status);
  }
}
