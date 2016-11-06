package com.example.repository;

import com.example.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRep extends JpaRepository<Post, Long> {
}
