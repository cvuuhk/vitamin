package cn.cvuuhk.vitamin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "user")
public class User implements Serializable {
  private static final long serialVersionUID = 6786871439961636034L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  private Role role;

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getId() {
    return id;
  }

  public User setId(String id) {
    this.id = id;
    return this;
  }

  public Role getRole() {
    return role;
  }

  public User setRole(Role role) {
    this.role = role;
    return this;
  }
}
