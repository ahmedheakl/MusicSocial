package com.example.userservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    UserEntity findById(Integer id);

    List<UserEntity> findByUsername(String username);

    List<UserEntity> findByPassword(String password);

}