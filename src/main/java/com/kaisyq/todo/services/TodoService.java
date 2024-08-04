package com.kaisyq.todo.services;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kaisyq.todo.dtos.TodoDto;
import com.kaisyq.todo.exceptions.ValidateException;
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

    private final String DEFAULT_VALIDATE_MESSAGE_FORMAT = "Todo with id:%d not found!";

    public List<TodoDto> getList() {
        final var entityList = this.todoRepository.findAll();
        return this.todoListMapper.toDto(entityList);
    }

    public void save(@NonNull final TodoDto todo) {
        final var entity = this.todoMapper.toEntity(todo);
        
        this.todoRepository.saveAndFlush(entity);
    }

    public TodoDto getById(final int id) {
        final var todo = this.todoRepository.findById(id);

        if (todo.isEmpty()) {
            throw new ValidateException(String.format(DEFAULT_VALIDATE_MESSAGE_FORMAT, id));
        }

        return todo.map(this.todoMapper::toDto)
            .orElseThrow(() -> new ValidateException("Unexpected error occurred"));
    }


    public void update(final int id, final TodoDto updatedTodoDto) {
        final var todoToUpdate = todoRepository.findById(id);

        if (todoToUpdate.isEmpty()) {
            String errorMessage = String.format(DEFAULT_VALIDATE_MESSAGE_FORMAT, id);
            throw new ValidateException(errorMessage);
        }

        final var updatedTodo = todoMapper.toEntity(updatedTodoDto);

        todoToUpdate.get().setTitle(updatedTodo.getTitle());
        todoToUpdate.get().setSubtitle(updatedTodo.getSubtitle());
        todoToUpdate.get().setText(updatedTodo.getText());
        
        todoRepository.saveAndFlush(todoToUpdate.get());
    }

    public void delete(final int id) {
        this.todoRepository.deleteById(id);
    }

}

