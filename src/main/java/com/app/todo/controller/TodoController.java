package com.app.todo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.app.todo.services.TodoServices;


import com.app.todo.model.Todo;
import com.app.todo.model.User;
import com.app.todo.repository.UserRepository;

@Controller
public class TodoController {

    @Autowired
    private TodoServices todoServices;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/todos")
    public String home(Model model,
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }

        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        if (optionalUser.isEmpty()) {
            return "redirect:/login";
        }

        User user = optionalUser.get();

        List<Todo> unfinished = todoServices.getTodoByStatus(0);
        List<Todo> finished = todoServices.getTodoByStatus(1);

        model.addAttribute("todos", unfinished);
        model.addAttribute("finishedTodos", finished);
        model.addAttribute("name", user.getName());

        return "home";
    }

    @PostMapping("/todos/create")
    public String addTodo(@RequestParam String task,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline,
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails) {

        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        if (optionalUser.isEmpty()) {
            return "redirect:/login";
        }

        Todo todo = new Todo();
        todo.setTask(task);
        todo.setState(0);
        todo.setDate(deadline);
        todo.setUser(optionalUser.get());

        todoServices.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/findById")
    @ResponseBody
    public Todo findById(@RequestParam("id") Long Id){
        return todoServices.getTodoById(Id);
    }

    @PostMapping("/todos/edit")
    public String editTodo(@RequestParam Long id,
            @RequestParam(required = false) String task,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline) {
        Todo todoOptional = todoServices.getTodoById(id);

        if (todoOptional != null) {
            todoOptional.setTask(task);
            todoOptional.setDate(deadline);
            todoServices.saveTodo(todoOptional);
        }

        return "redirect:/todos";
    }

    @PostMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoServices.deleteTodo(id);
        return "redirect:/todos";
    }

    @PostMapping("/done/{id}")
    public String maekAsDone(@PathVariable Long id) {
        todoServices.markAsDone(id);
        return "redirect:/todos";
    }

    @PostMapping("/undo")
    public String undoTodo(@RequestParam Long id, @RequestParam(required = false) String task,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline) {
        Todo todoOptional = todoServices.getTodoById(id);

        if (todoOptional != null) {
            todoOptional.setDate(deadline);
            todoOptional.setState(0);
            todoServices.saveTodo(todoOptional);
        }

        return "redirect:/todos";
    }

}