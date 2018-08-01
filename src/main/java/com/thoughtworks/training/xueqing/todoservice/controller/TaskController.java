package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.Task;
import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.service.TaskService;
import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> get() throws IOException {
        return taskService.find();
    }
    @GetMapping("/tasks/{id}")
    public Task getOne(@PathVariable Integer id) throws IOException {
        return taskService.findOne(id);
    }
    @PostMapping("/tasks")
    public void save(@RequestBody Task task){
        taskService.save(task);
    }
    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Integer id){
        taskService.delete(id);
    }
}
