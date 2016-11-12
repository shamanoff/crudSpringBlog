package com.example.repository;

import com.example.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRep extends JpaRepository<Roles, Long> {
}
