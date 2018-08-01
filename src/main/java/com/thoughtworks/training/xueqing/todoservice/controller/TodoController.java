package com.thoughtworks.training.xueqing.todoservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @PutMapping("/todos")
    public void delete(@RequestBody Integer id,@RequestBody TodoItem todo){
        todoService.update(id,todo);
    }

}
