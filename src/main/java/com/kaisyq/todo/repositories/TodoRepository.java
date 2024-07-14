package com.kaisyq.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaisyq.todo.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    
}
