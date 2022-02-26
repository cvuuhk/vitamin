package cn.cvuuhk.vitamin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "teacher")
@JsonIgnoreProperties("courses")
public class Teacher implements Serializable {
  private static final long serialVersionUID = 2003506131622871892L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
  private Set<Course> courses;

  public String getName() {
    return name;
  }

  public Teacher setName(String name) {
    this.name = name;
    return this;
  }

  public String getId() {
    return id;
  }

  public Teacher setId(String id) {
    this.id = id;
    return this;
  }

  public Set<Course> getCourses() {
    return courses;
  }

  public Teacher setCourses(Set<Course> courses) {
    this.courses = courses;
    return this;
  }
}
