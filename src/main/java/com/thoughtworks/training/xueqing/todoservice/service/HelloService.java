package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.People;
import com.thoughtworks.training.xueqing.todoservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {
    @Autowired
    private PersonRepository personRepository;

    public People find(String name){
        List<People> persons = personRepository.list();
        return persons.stream().filter(person->person.getName().equals(name)).findFirst().get();
    }
    public List list(){
        return personRepository.lists();
    }
}
