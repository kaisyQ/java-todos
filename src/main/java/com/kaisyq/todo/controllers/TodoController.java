package com.kaisyq.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaisyq.todo.services.TodoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public final class TodoController {
    
    private final TodoService todoService;

    @GetMapping("")
    public String getList(Model model) {

        var todos = todoService.getList();

        model.addAttribute("todos", todos);

        return "index";
    }


}
