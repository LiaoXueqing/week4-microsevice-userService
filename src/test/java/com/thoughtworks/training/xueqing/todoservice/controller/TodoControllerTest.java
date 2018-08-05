package com.thoughtworks.training.xueqing.todoservice.controller;

import com.thoughtworks.training.xueqing.todoservice.model.Todo;
import com.thoughtworks.training.xueqing.todoservice.model.User;
import com.thoughtworks.training.xueqing.todoservice.repository.TodoRepository;
import com.thoughtworks.training.xueqing.todoservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TodoRepository todoRepository;
    @MockBean
    private UserService userService;
    private User userFixture = new User(1, "xue", "xue");

    @Test
    public void shouldUnauthenticatedBeforeLogin()throws Exception{
        mockMvc.perform(get("/todos")).andExpect(unauthenticated());
    }

//    @Test
//    public void shouldReturnListWithSecurity()throws Exception{
//        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("ddd", null, Collections.emptyList()));
//        when(userService.findByName("xue")).thenReturn(userFixture);
//        when(todoRepository.findAllByUserIdEquals(1))
//                .thenReturn(Collections.singletonList(new Todo(1,"todo 1",false,false,new Date(),1,Collections.emptyList())));
//
//        mockMvc.perform(get("/todos"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].name").value("todo 1"))
//                .andExpect(jsonPath("$[0].deleted").value(false));
//    }
    @Test
    public void shouldReturnListWhenAuthenticated()throws Exception{
        when(userService.findByName("xue")).thenReturn(userFixture);
        when(todoRepository.findAllByUserIdEquals(1))
                .thenReturn(Collections.singletonList(new Todo(1,"todo 1",false,false,new Date(),1,Collections.emptyList())));
        mockMvc.perform(get("/todos")
                .with(authentication(new UsernamePasswordAuthenticationToken("xue", null, Collections.emptyList()))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("todo 1"));
    }

}