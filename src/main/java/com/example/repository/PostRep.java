package com.example.repository;

import com.example.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRep extends JpaRepository<Post, Long> {

    List<Post> findPostByAuthorIdOrderByDateDesc(Long authorId);
//    List<Post> findPostOrderByDate();

}
