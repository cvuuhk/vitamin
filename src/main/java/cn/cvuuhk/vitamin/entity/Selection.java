package cn.cvuuhk.vitamin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(schema = "public", name = "selection")
public class Selection implements Serializable {
  private static final long serialVersionUID = -2052206373262700831L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "score")
  private Integer score;

  @Column(name = "create_time", nullable = false)
  private Instant createTime;

  @ManyToOne
  @JoinColumn(name = "student_id", referencedColumnName = "id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id", referencedColumnName = "id")
  private Course course;

  public Instant getCreateTime() {
    return createTime;
  }

  public Selection setCreateTime(Instant createTime) {
    this.createTime = createTime;
    return this;
  }

  public Integer getScore() {
    return score;
  }

  public Selection setScore(Integer score) {
    this.score = score;
    return this;
  }

  public String getId() {
    return id;
  }

  public Selection setId(String id) {
    this.id = id;
    return this;
  }

  public Student getStudent() {
    return student;
  }

  public Selection setStudent(Student student) {
    this.student = student;
    return this;
  }

  public Course getCourse() {
    return course;
  }

  public Selection setCourse(Course course) {
    this.course = course;
    return this;
  }
}
