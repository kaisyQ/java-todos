package com.kaisyq.todo.dtos;

import java.util.Date;

import lombok.Data;

@Data
public final class TodoDto {
    private final Integer id;
    private final String title;
    private final String subtitle;
    private final String text;
    private final Date createdAt;
}
