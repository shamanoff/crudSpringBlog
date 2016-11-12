package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long user_id;
  @Column
  private String user_name;
  @Column
  private String password;

  @Transient
  private String confirmPassword;

  @Column
  private Long user_role;


  @ManyToMany(fetch = EAGER)
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "user_name", referencedColumnName = "user_name"),
          inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
  )
  private List<Roles> roles;


  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
            "user_id=" + user_id +
            ", user_name='" + user_name + '\'' +
            ", user_role=" + user_role +
            ", password=" + password +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(getUser_id(), user.getUser_id()) &&
            Objects.equals(getUser_name(), user.getUser_name()) &&
            Objects.equals(getUser_role(), user.getUser_role()) &&
            Objects.equals(getPassword(), user.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUser_id(), getUser_name(), getUser_role(), getPassword());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return this.user_name;
  }

  public List<Roles> getRole(){
    return roles;

  }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public Long setUser_role(List<Roles> roles) {
    return this.user_role;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}
