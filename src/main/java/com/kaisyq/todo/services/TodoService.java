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
        final var entityList = this.todoRepository.findAll();

        return this.todoListMapper.toDto(entityList);
    }

    public TodoDto save(final TodoDto todo) {
        final var entity = this.todoMapper.toEntity(todo);

        return this.todoMapper.toDto(this.todoRepository.saveAndFlush(entity));
    }

}
