package com.example.eldocuments.feteres.user.repositories;

import com.example.eldocuments.feteres.user.entities.UKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UKeyRepository extends JpaRepository<UKeyEntity,Integer> {

    Optional<UKeyEntity> findByUkey(String uKey);
}
