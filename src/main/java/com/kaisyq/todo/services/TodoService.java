package com.kaisyq.todo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaisyq.todo.dtos.TodoDto;
import com.kaisyq.todo.mappers.TodoListMapper;
import com.kaisyq.todo.mappers.TodoMapper;
import com.kaisyq.todo.repositories.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public final class TodoService {
    private final TodoRepository todoRepository;
    private final TodoListMapper todoListMapper;
    private final TodoMapper todoMapper;

    public List<TodoDto> getList() {
        var entityList = this.todoRepository.findAll();

        return this.todoListMapper.toDto(entityList);
    }

    public void createTodo(TodoDto todo) {
        this.todoRepository.findAll();
    }

}
