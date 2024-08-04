package com.kaisyq.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaisyq.todo.entities.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByUsername(String username);
}
