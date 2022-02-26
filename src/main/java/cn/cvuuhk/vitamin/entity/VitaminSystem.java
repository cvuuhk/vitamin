package cn.cvuuhk.vitamin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "vitamin_system")
public class VitaminSystem implements Serializable {
  private static final long serialVersionUID = -3759798993566617502L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "status_id", referencedColumnName = "id")
  private Status status;

  public Status getStatus() {
    return status;
  }

  public VitaminSystem setStatus(Status status) {
    this.status = status;
    return this;
  }

  public String getId() {
    return id;
  }

  public VitaminSystem setId(String id) {
    this.id = id;
    return this;
  }
}
