package com.thoughtworks.training.xueqing.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.xueqing.todoservice.controller.TodoController;
import com.thoughtworks.training.xueqing.todoservice.model.Todo;
import com.thoughtworks.training.xueqing.todoservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
@DataJpaTest
@RunWith(SpringRunner.class)
public class TodoRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void shouldReturnTodoByUserId() {
        userRepository.save(new User(1, "xue", "xue", ImmutableList.of()));
        todoRepository.save(new Todo(1, "todo", false,false,new Date(),1,ImmutableList.of()));
        List<Todo> list = todoRepository.findAllByUserIdEquals(1);
        assertThat(list.size(),is(1));
    }
}