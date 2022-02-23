package cn.cvuuhk.vitamin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "operation")
public class Operation implements Serializable {
  private static final long serialVersionUID = -3042216179515421277L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "method", nullable = false, length = 6)
  private String method;

  @Column(name = "pattern", nullable = false)
  private String pattern;

  @Column(name = "comment", nullable = false)
  private String comment;

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "operations")
  private Set<Role> roles;

  public String getComment() {
    return comment;
  }

  public Operation setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public String getPattern() {
    return pattern;
  }

  public Operation setPattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  public String getMethod() {
    return method;
  }

  public Operation setMethod(String method) {
    this.method = method;
    return this;
  }

  public String getId() {
    return id;
  }

  public Operation setId(String id) {
    this.id = id;
    return this;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public Operation setRoles(Set<Role> roles) {
    this.roles = roles;
    return this;
  }
}
