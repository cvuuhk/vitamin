package cn.cvuuhk.vitamin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "course")
@JsonIgnoreProperties({"selections"})
public class Course implements Serializable {
  private static final long serialVersionUID = -7320474305121015005L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "total", nullable = false)
  private Integer total;

  @Column(name = "remain", nullable = false)
  private Integer remain;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
  private Set<Selection> selections;

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  private Teacher teacher;

  public Integer getRemain() {
    return remain;
  }

  public Course setRemain(Integer remain) {
    this.remain = remain;
    return this;
  }

  public Integer getTotal() {
    return total;
  }

  public Course setTotal(Integer total) {
    this.total = total;
    return this;
  }

  public String getName() {
    return name;
  }

  public Course setName(String name) {
    this.name = name;
    return this;
  }

  public String getId() {
    return id;
  }

  public Course setId(String id) {
    this.id = id;
    return this;
  }

  public Set<Selection> getSelections() {
    return selections;
  }

  public Course setSelections(Set<Selection> selections) {
    this.selections = selections;
    return this;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public Course setTeacher(Teacher teacher) {
    this.teacher = teacher;
    return this;
  }
}
