package com.thoughtworks.training.xueqing.todoservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.xueqing.todoservice.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}
	public static void testObjectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "{ \"name\" : \"xueqing\", \"password\" : \"xueqing\" }";
		try {
			User user = objectMapper.readValue(json, User.class);
			System.out.println(user.getName()+" "+user.getPassword());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
