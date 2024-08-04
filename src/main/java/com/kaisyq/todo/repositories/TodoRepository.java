package com.kaisyq.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaisyq.todo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
