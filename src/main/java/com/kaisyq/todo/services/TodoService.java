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

    private final String TODO_NOT_FOUND_MESSAGE_FORMAT = "Todo with id:%d not found!";

    /**
     * Retrieves all TodoDto objects from the repository and maps them to a list of TodoDto objects.
     *
     * @return  A list of TodoDto objects representing all Todo entities in the repository
     */
    public List<TodoDto> getList() {
        // Retrieve all Todo entities from the repository
        final var entityList = this.todoRepository.findAll();
        
        // Map the list of Todo entities to a list of TodoDto objects
        return this.todoListMapper.toDto(entityList);
    }

    /**
     * Saves a new TodoDto object to the repository.
     *
     * @param  todo  The TodoDto object to save
     * @throws None
     */
    public void save(@NonNull final TodoDto todo) {
        // Convert the TodoDto object to an entity
        final var entity = this.todoMapper.toEntity(todo);
        
        // Save and flush the entity to the repository
        this.todoRepository.saveAndFlush(entity);
    }

    /**
     * Retrieves a TodoDto object with the specified ID.
     * 
     * @param  id  The ID of the TodoDto object to retrieve
     * @return     The TodoDto object with the specified ID
     * @throws ValidateException If the TodoDto object with the specified ID is not found
     */
    public TodoDto getById(final int id) {
        // Find the TodoDto object with the specified ID
        final var todo = this.todoRepository.findById(id)
            .orElseThrow(() -> new ValidateException(
                String.format(TODO_NOT_FOUND_MESSAGE_FORMAT, id))); // Throw an exception if the TodoDto object is not found

        // Convert the Todo entity to a TodoDto object and return it
        return this.todoMapper.toDto(todo);
    }

    /**
     * Updates a todo item with the specified ID.
     * 
     * @param  id      The ID of the todo item to update
     * @param  updatedTodoDto The updated todo item data
     * @throws ValidateException If the todo item with the specified ID is not found
     */
    public void update(final int id, @NonNull final TodoDto updatedTodoDto) throws ValidateException {
        // Find the todo item with the specified ID
        final var todoToUpdate = todoRepository.findById(id)
            .orElseThrow(() -> new ValidateException(
                String.format(TODO_NOT_FOUND_MESSAGE_FORMAT, id)));

        // Convert the updated todo item data to an entity
        final var updatedTodo = todoMapper.toEntity(updatedTodoDto);

        // Update the properties of the todo item
        todoToUpdate.setTitle(updatedTodo.getTitle());
        todoToUpdate.setSubtitle(updatedTodo.getSubtitle());
        todoToUpdate.setText(updatedTodo.getText());
        
        // Save and flush the updated todo item to the repository
        todoRepository.saveAndFlush(todoToUpdate);
    }

    /**
     * Deletes a Todo item from the repository by its ID.
     *
     * @param  id  the ID of the Todo item to delete
     */
    public void delete(final int id) {
        // Delete the Todo item from the repository by its ID
        this.todoRepository.deleteById(id);
    }

}

