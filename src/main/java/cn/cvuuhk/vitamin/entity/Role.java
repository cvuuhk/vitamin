package cn.cvuuhk.vitamin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "role")
@JsonIgnoreProperties({"users", "operations"})
public class Role implements Serializable {
  private static final long serialVersionUID = -4684147359756993379L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name")
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
  private Set<User> users;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "role_operation",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id"))
  private Set<Operation> operations;

  public String getName() {
    return name;
  }

  public Role setName(String name) {
    this.name = name;
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
