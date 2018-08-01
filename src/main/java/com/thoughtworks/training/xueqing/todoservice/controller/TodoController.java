package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Integer id){
        todoService.delete(id);
    }

    @PutMapping("/todos/{id}")
    public void update(@PathVariable Integer id,@RequestBody TodoItem todo){
        todoService.update(id,todo);
    }

    @PutMapping("/todos/completed/{id}")
    public void completed(@PathVariable Integer id){
        todoService.completed(id);
    }
    @PutMapping("/todos/deleted/{id}")
    public void deleted(@PathVariable Integer id){
        todoService.deleted(id);
    }

}
