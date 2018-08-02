package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;
    @Autowired
    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }



    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    public List<TodoItem> findAll(String name){
        return todoRepository.findAllByUserIdEquals(userService.findByName(name).getId());
    }

    public void save(TodoItem todoItem){
        todoRepository.save(todoItem);
    }
    public TodoItem findById(Integer id){
        return todoRepository.findOne(id);
    }
    public TodoItem findById(Integer id,String name){
        return todoRepository.findByIdEqualsAndUserIdEquals(id, userService.findByName(name).getId());
    }

    public TodoItem update(Integer id,TodoItem newtodo) {
        TodoItem todo = todoRepository.findOne(id);
        todo.setName(newtodo.getName());
        todo.setCompleted(newtodo.getCompleted());
        todo.setDeleted(newtodo.getDeleted());
        todo.setTime(newtodo.getTime());
        todo.setTasks(newtodo.getTasks());
        return todoRepository.save(todo);
    }

    public void completed(Integer id) {
        TodoItem todo = todoRepository.findOne(id);
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }
    public void deleted(Integer id) {
        TodoItem todo = todoRepository.findOne(id);
        todo.setDeleted(!todo.getDeleted());
        todoRepository.save(todo);
    }
}
