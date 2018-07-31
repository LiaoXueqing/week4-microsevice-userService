package com.thoughtworks.training.xueqing.todoservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.xueqing.todoservice.model.People;
import com.thoughtworks.training.xueqing.todoservice.service.HelloService;
import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController 
public class PersonsController {
    @Autowired
    private HelloService helloService;
//    @Autowired
//    private ObjectMapper objectMapper;
//    readValue
//    writeValue
    @GetMapping("/users")
    public List<People> users(){
        return helloService.list();
    }
}
