package com.thoughtworks.training.xueqing.todoservice.repository;

import com.thoughtworks.training.xueqing.todoservice.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    //    @Autowired
//    User userFixture;
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    private MockMvc mockmvc;

    @Before
    public void setUp() {
//        when(userRepository.findOne(1)).thenReturn(userFixture);
    }

    @Test
    public void findByNameEquals() {
        userRepository.save(new User(11, "xue", "xue"));
        Optional<User> user = userRepository.findByNameEquals("xue");
        assertTrue(user.isPresent());
        assertThat(user.get().getName(), is("xue"));
    }

    @Test
    public void shouldReturn401() throws Exception {
        mockmvc.perform(get("/todos"))
                .andExpect(unauthenticated());
    }

//    @Test
//    public void shouldReturnTodosWithAuthentication() throws Exception {
//        mockmvc.perform(get("todos"))
//                .with(authentication(new UsernamePasswordAuthenticationToken("xue",
//                        null,
//                        Collections.emptyList())))
//                .andExpect(status().isOk());
}