package com.app.todo.services;

import com.app.todo.model.Todo;
import com.app.todo.model.User;
import com.app.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServices {
    
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Optional<Todo> getTodoByUser(User userId) {
        return todoRepository.findByUser(userId);
    }

    public List<Todo> getTodoByStatus(int state) {
        return todoRepository.findByState(state);
    }

    public List<Todo> getByTodoDate(LocalDate date) {
        return todoRepository.findByDate(date);
    }

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void markAsDone(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setState(1);
            todoRepository.save(todo);
        }
    }
}