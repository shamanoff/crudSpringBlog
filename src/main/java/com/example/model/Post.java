package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", length = 6, nullable = false)
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "text")
  private String text;
  @Column(name = "date")
  private java.sql.Date date;
  @Column(name = "tag")
  private Long tag;


  @ManyToOne
  @JoinColumn(name = "tag", insertable = false, updatable = false)
  private Tag tag_name;


  public Post() {
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", text='" + text + '\'' +
            ", date=" + date +
            ", tag=" + tag +
            '}';
  }
}
