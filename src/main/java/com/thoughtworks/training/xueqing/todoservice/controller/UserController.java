package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.model.User;
import com.thoughtworks.training.xueqing.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void save(@RequestBody User user) throws IOException {
        userService.save(user);
    }

    @GetMapping("/users")
    public List<User> get() throws IOException {
        return userService.find();
    }
    @GetMapping("/users/{id}")
    public User getOne(@PathVariable Integer id) throws IOException {
        return userService.findOne(id);
    }
    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable Integer id) throws IOException {
        userService.delete(id);
    }
}
