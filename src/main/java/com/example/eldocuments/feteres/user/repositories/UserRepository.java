package com.example.eldocuments.feteres.user.repositories;

import com.example.eldocuments.feteres.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> { }
