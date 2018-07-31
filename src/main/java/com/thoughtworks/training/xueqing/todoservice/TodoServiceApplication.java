package com.thoughtworks.training.xueqing.todoservice;

import com.thoughtworks.training.xueqing.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@SpringBootApplication
public class TodoServiceApplication {
//@Autowired
//	TodoService ts;
	public static void main(String[] args) {

		SpringApplication.run(TodoServiceApplication.class, args);
//		getFromFile();
//		new TodoServiceApplication().printTodos();
	}
//	public void printTodos() {
//		ts.todos();
//	}
	public static void getFromFile(){
		File file = new File("src/main/resources/todos.json");
        BufferedReader reader=null;
		String temp = "";
		try {
            reader=new BufferedReader(new FileReader(file));
			while((temp=reader.readLine())!=null){
                System.out.println(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (Exception e){

                }
            }
        }
	}
}
