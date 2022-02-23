package cn.cvuuhk.vitamin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "admin")
public class Admin implements Serializable {
  private static final long serialVersionUID = -1072502428717170481L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  public String getName() {
    return name;
  }

  public Admin setName(String name) {
    this.name = name;
    return this;
  }

  public String getId() {
    return id;
  }

  public Admin setId(String id) {
    this.id = id;
    return this;
  }
}
