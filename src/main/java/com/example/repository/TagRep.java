package com.example.repository;

import com.example.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRep extends JpaRepository<Tag, Long> {
}
