package cn.cvuuhk.vitamin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "status")
public class Status implements Serializable {
  private static final long serialVersionUID = 2138693637617793444L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "comment")
  private String comment;

  public String getComment() {
    return comment;
  }

  public Status setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public String getName() {
    return name;
  }

  public Status setName(String name) {
    this.name = name;
    return this;
  }

  public String getId() {
    return id;
  }

  public Status setId(String id) {
    this.id = id;
    return this;
  }
}
