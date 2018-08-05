package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.Todo;
import com.thoughtworks.training.xueqing.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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



    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> findAll(String name){
        return todoRepository.findAllByUserIdEquals(userService.findByName(name).getId());
    }

    public Todo save(Todo todo){
        todo.setTime(new Date());
        System.out.println("----"+ todo);
        return todoRepository.save(todo);
    }
    public Todo findById(Integer id){
        return todoRepository.findOne(id);
    }
    public Todo findById(Integer id, String name){
        return todoRepository.findByIdEqualsAndUserIdEquals(id, userService.findByName(name).getId());
    }

    public Todo update(Integer id, Todo newtodo) {
        Todo todo = todoRepository.findOne(id);
        todo.setName(newtodo.getName());
        todo.setCompleted(newtodo.getCompleted());
        todo.setDeleted(newtodo.getDeleted());
        todo.setTime(newtodo.getTime());
        todo.setTasks(newtodo.getTasks());
        return todoRepository.save(todo);
    }

    public void completed(Integer id) {
        Todo todo = todoRepository.findOne(id);
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }
    public void deleted(Integer id) {
        Todo todo = todoRepository.findOne(id);
        todo.setDeleted(!todo.getDeleted());
        todoRepository.save(todo);
    }
}
