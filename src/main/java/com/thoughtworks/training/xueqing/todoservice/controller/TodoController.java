package com.thoughtworks.training.xueqing.todoservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;
//    @GetMapping("/todos")
//    public String getTodos(Model model){
//        List<TodoItem> list = todoService.list();
//        System.out.println(list);
//        model.addAttribute("todos",list);
//        return "todos";
//    }

    @GetMapping("/todos")
    public List<TodoItem> Todos() throws IOException {
//        Response.addHeader("Access-Control-Allow-Origin", "http://192.168.56.130");

        String json = todoService.allTodos();
        System.out.println("---todos---"+json);

        ObjectMapper objectMapper = new ObjectMapper();
        List<TodoItem> list = objectMapper.readValue(json,
                new TypeReference<List<TodoItem>>(){}
        );

        return list;
    }
    @GetMapping("/todos/{id}")
    public TodoItem TodoItemById(@PathVariable int id) throws IOException {

        String json = todoService.allTodos();
        System.out.println("---todos---"+json);

        ObjectMapper objectMapper = new ObjectMapper();
        List<TodoItem> list = objectMapper.readValue(json,
                new TypeReference<List<TodoItem>>(){}
        );
        TodoItem todoItem = list.stream().filter(item->item.getId()==id).collect(Collectors.toList()).get(0);
        System.out.println("todoItem---"+todoItem);
        return todoItem;
    }
}
