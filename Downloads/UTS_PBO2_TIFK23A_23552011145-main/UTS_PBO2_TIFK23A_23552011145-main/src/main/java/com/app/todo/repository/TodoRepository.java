package com.app.todo.repository;

import com.app.todo.model.Todo;
import com.app.todo.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByUser(User user);
    List<Todo> findByState(int state);
    List<Todo> findByDate(LocalDate date);
}
