package cn.cvuuhk.vitamin.service;

import cn.cvuuhk.vitamin.dao.StudentRepository;
import cn.cvuuhk.vitamin.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentService {
  @Resource StudentRepository repository;

  @Transactional
  public Student getStudent(String id) {
    return repository.findById(id).get();
  }
}
