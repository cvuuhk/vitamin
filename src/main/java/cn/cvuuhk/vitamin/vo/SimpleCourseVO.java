package cn.cvuuhk.vitamin.vo;

import cn.cvuuhk.vitamin.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class SimpleCourseVO {

  private String id;
  private String name;

  public SimpleCourseVO() {}

  public SimpleCourseVO(Course course) {
    this.id = course.getId();
    this.name = course.getName();
  }

  public String getId() {
    return id;
  }

  public SimpleCourseVO setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public SimpleCourseVO setName(String name) {
    this.name = name;
    return this;
  }
}
