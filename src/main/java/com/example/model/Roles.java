package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "roles")
public class Roles implements GrantedAuthority {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String role;

  public Roles() {
  }

  @Override
  public String toString() {
    return "Roles{" +
            "id=" + id +
            ", role='" + role + '\'' +
            '}';
  }

  @Override
  public String getAuthority() {
    return getRole();
  }
}
