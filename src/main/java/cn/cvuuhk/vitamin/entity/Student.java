package cn.cvuuhk.vitamin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "student")
public class Student implements Serializable {
  private static final long serialVersionUID = 5697431088362835092L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
  private Set<Selection> selections;

  public String getName() {
    return name;
  }

  public Student setName(String name) {
    this.name = name;
    return this;
  }

  public String getId() {
    return id;
  }

  public Student setId(String id) {
    this.id = id;
    return this;
  }

  public Set<Selection> getSelections() {
    return selections;
  }

  public Student setSelections(Set<Selection> selections) {
    this.selections = selections;
    return this;
  }
}
