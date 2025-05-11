package com.app.todo.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_todo")
    private Long id;

    private String task;

    @Column(name = "deadline")
    private LocalDate date;

    @Column(name = "status")
    private int state;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Todo(){}

    public Todo(String task, LocalDate date, int state, User user){
        this.task = task;
        this.date = date;
        this.state = state;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
