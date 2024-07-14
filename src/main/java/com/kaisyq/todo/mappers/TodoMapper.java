package com.kaisyq.todo.mappers;

import org.mapstruct.Mapper;

import com.kaisyq.todo.dtos.TodoDto;
import com.kaisyq.todo.entities.Todo;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoDto toDto(Todo entity);
    Todo toEntity(TodoDto dto);
}
