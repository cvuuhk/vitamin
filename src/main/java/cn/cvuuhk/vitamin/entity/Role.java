package cn.cvuuhk.vitamin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "role")
public class Role implements Serializable {
  private static final long serialVersionUID = -4684147359756993379L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "comment")
  private String comment;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
  private Set<User> users;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "role_operation",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id"))
  private Set<Operation> operations;

  public String getComment() {
    return comment;
  }

  public Role setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public String getId() {
    return id;
  }

  public Role setId(String id) {
    this.id = id;
    return this;
  }

  public Set<User> getUsers() {
    return users;
  }

  public Role setUsers(Set<User> users) {
    this.users = users;
    return this;
  }

  public Set<Operation> getOperations() {
    return operations;
  }

  public Role setOperations(Set<Operation> operations) {
    this.operations = operations;
    return this;
  }
}
