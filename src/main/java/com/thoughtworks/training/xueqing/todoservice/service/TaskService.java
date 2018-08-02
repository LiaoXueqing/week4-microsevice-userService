package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.Task;
import com.thoughtworks.training.xueqing.todoservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> find() {
        return taskRepository.findAll();
    }
    public void save(Task task){
        taskRepository.save(task);
    }
    public Task findOne(Integer id){
        return taskRepository.findOne(id);
    }
    public void delete(Integer id){
        taskRepository.delete(id);
    }

}
