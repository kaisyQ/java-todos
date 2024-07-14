package com.kaisyq.todo.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.kaisyq.todo.dtos.TodoDto;
import com.kaisyq.todo.entities.Todo;

@Mapper(componentModel = "spring", uses = TodoMapper.class)
public interface TodoListMapper {
    List<Todo> toEntity (List<TodoDto> dtoList);
    List<TodoDto> toDto (List<Todo> entityList);
}
