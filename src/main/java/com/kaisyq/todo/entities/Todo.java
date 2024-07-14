package com.kaisyq.todo.entities;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public final class Todo {
    
    @Id
    private Integer id;

    @Nonnull
    private String title;

    @Nonnull
    private String subtitle;

    @Nonnull
    private String text;

    @Nonnull
    private Date createdAt;

}
