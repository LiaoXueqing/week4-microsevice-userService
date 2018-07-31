package com.thoughtworks.training.xueqing.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.xueqing.todoservice.model.People;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    public List<People> list(){
        return ImmutableList.of(
                new People("xueqing","xian"),
                new People("xueqing1","xian"),
                new People("xueqing2","xian"),
                new People("xueqing3","xian"),
                new People("xueqing4","xian")
        );
    }
    public List<People> lists(){
        return ImmutableList.of(
                new People("xueqing","xian"),
                new People("xueqing1","xian"),
                new People("xueqing2","xian"),
                new People("xueqing3","xian"),
                new People("xueqing4","xian")
        );
    }

}
