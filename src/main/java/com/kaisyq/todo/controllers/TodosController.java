package com.kaisyq.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/todos")
@Controller
public final class TodosController {
    
    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("messageq", "test text");

        return "index";
    }
}
