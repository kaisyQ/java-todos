package com.kaisyq.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaisyq.todo.dtos.TodoDto;
import com.kaisyq.todo.services.TodoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("rest/v1/todos")
@RequiredArgsConstructor
public final class TodoController {
    
    @Autowired
    private final TodoService todoService;

    @PostMapping("")
    public ResponseEntity<TodoDto> save(@RequestBody final TodoDto todo) {
        this.todoService.save(todo);
        
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<TodoDto>> getAll () {
        final var result = this.todoService.getList();
        return ResponseEntity.ok(result);
    }


    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable final int id) {
        final var result = this.todoService.getById(id);

        return ResponseEntity.ok(result);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable final int id, @RequestBody final TodoDto todo) {
        this.todoService.update(id, todo);
        
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable final int id) {

        this.todoService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
