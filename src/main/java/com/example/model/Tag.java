package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@Table(name = "tag")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", length = 6, nullable = false)
  private Long id;
  @Column(name = "tag")
  private String tag;

  public Tag() {
  }

  @Override
  public String toString() {
    return "Tag{" +
            "id=" + id +
            ", tag='" + tag + '\'' +
            '}';
  }
}
