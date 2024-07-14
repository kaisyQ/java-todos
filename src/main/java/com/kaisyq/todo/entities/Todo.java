package com.kaisyq.todo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public final class Todo {
    
    @Id
    private final Integer id;

    private final String title;

    private final String subtitle;

    private final String text;

    private final Date createdAt;

}
