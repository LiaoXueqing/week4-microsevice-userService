package com.thoughtworks.training.xueqing.todoservice.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.sun.tools.javac.comp.Todo;
import com.thoughtworks.training.xueqing.todoservice.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class TodoRepository {

    public List list(){
        return ImmutableList.of(
                new TodoItem(1,"todo1",false,false,"2018-7-26"),
                new TodoItem(2,"todo2",false,false,"2018-7-26"),
                new TodoItem(3,"todo3",false,false,"2018-7-26"),
                new TodoItem(4,"todo4",false,false,"2018-7-26"),
                new TodoItem(5,"todo5",false,false,"2018-7-26"),
                new TodoItem(6,"todo6",false,false,"2018-7-26")

        );
    }

}
