package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<TodoItem> find() {
        return todoRepository.findAll();
    }
    public void save(TodoItem todoItem){
        todoRepository.save(todoItem);
    }
    public TodoItem findOne(Integer id){
        return todoRepository.findOne(id);
    }
    public void delete(Integer id){
        todoRepository.delete(id);
    }

}
