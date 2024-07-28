package com.kaisyq.todo.controllers.rest;

import org.springframework.web.bind.annotation.RestController;

import com.kaisyq.todo.dtos.TodoDto;
import com.kaisyq.todo.services.TodoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("rest/v1/todos")
@RequiredArgsConstructor
public final class TodoRestController {
    
    @Autowired
    private final TodoService todoService;

    @PostMapping("")
    public TodoDto save(@RequestBody TodoDto todo) {

        this.todoService.save(todo);

        return todo;
    }
    
}
