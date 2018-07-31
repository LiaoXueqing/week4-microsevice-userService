package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.People;
import com.thoughtworks.training.xueqing.todoservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
    @GetMapping("")
    public String Hello1(){
        System.out.println("hello1");
        return "hello1";
    }
    @GetMapping("/hello/{name}")
    public String Hello(@PathVariable String name, Model model){

        People p = helloService.find(name);
        System.out.println("p:"+p);
        model.addAttribute("people",p);

        return "hello";
    }
}
