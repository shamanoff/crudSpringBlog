package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
  private Timestamp date;
  @Column(name = "tag")
  private Long tagId;
  @Column(name = "author_id")
  private Long authorId;


  @ManyToOne
  @JoinColumn(name = "tag", insertable = false, updatable = false)
  private Tag tag;


    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private User author;


  public Post() {
    this.date = Timestamp.valueOf(LocalDateTime.now());
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", text='" + text + '\'' +
            ", date=" + date +
            ", tagId=" + tagId +
            '}';
  }
}
