package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
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
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<TodoItem> get() throws IOException {
        return todoService.find();
    }
    @GetMapping("/todos/{id}")
    public TodoItem getOne(@PathVariable Integer id) throws IOException {
        return todoService.findOne(id);
    }
    @PostMapping("/todos")
    public void save(@RequestBody TodoItem todoItem){
        todoService.save(todoItem);
    }

    @PutMapping("/todos/{id}")
    public void update(@PathVariable Integer id,@RequestBody TodoItem todo){
        todoService.update(id,todo);
    }

    @PutMapping("/todos/completed/{id}")
    public void completed(@PathVariable Integer id){
        todoService.completed(id);
    }
    @DeleteMapping("/todos/{id}")
    public void deleted(@PathVariable Integer id){
        todoService.deleted(id);
    }

}
