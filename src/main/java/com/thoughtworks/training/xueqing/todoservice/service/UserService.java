package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.User;
import com.thoughtworks.training.xueqing.todoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> find() {
        return userRepository.findAll();
    }
    public void save(User user){
        userRepository.save(user);
    }
    public User findOne(Integer id){
        return userRepository.findOne(id);
    }
    public void delete(Integer id){
        userRepository.delete(id);
    }
}
