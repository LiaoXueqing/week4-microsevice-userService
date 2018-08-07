package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.User;
import com.thoughtworks.training.xueqing.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

//    @PostMapping("/verifications")
//    public ResponseEntity verifyToken(@RequestBody String token){
//        try{
//            return ResponseEntity.ok(userService.getUserByToken(token));
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//        }
//    }
    @GetMapping
    public List<User> list(){
        return userService.findAll();
    }
    @GetMapping("/logged")
    public User getLoggedUser(Principal user){
        return userService.findByName(user.getName());
    }
    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id){


        System.out.println("get user id id="+id);
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Integer id){
        userService.delete(id);
    }
}
