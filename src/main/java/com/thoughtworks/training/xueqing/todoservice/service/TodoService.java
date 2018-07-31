package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import com.thoughtworks.training.xueqing.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
@Service
public class TodoService {

    @Value(value= "classpath:static/todos.json")
    private Resource data;


    @Autowired
    private TodoRepository todoRepository;
    public List<TodoItem> list() {
        return todoRepository.list();
    }

    public String allTodos() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(data.getInputStream()));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) {
            message.append(line);
        }
        String defaultString=message.toString();
        String result=defaultString.replace("\r\n", "").replaceAll(" +", "");
        System.out.println(result);
        return result;
    }



}
