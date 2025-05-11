package com.app.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.app.todo.services.UserServices;
import com.app.todo.model.User;


@Controller
public class UserController {
    
    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login?error")
    public String loginError(Model model) {
        model.addAttribute("error", "Username atau Password salah");
        return "login";
    }

    @GetMapping("/register")
    public String registPage(Model model) {
        model.addAttribute("user", new User());
        return "regist";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userServices.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(String id) {
        userServices.deleteUser(id);
        return "redirect:/todos";
    }
}