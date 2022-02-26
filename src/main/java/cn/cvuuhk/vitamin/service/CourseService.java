package cn.cvuuhk.vitamin.service;

import cn.cvuuhk.vitamin.dao.CourseRepository;
import cn.cvuuhk.vitamin.entity.Course;
import cn.cvuuhk.vitamin.exception.CourseNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {
  @Resource CourseRepository repository;

  @Transactional
  public List<Course> all() {
    return repository.findAll();
  }

  @Transactional
  public Course getCourse(String id) {
    return repository.findById(id).orElseThrow(() -> new CourseNotExistException("课程不存在"));
  }
}
