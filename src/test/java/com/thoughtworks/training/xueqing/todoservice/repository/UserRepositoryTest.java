package com.thoughtworks.training.xueqing.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.xueqing.todoservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    private MockMvc mockmvc;


    @Test
    public void findByNameEquals() {
        userRepository.save(new User(11, "xue", "xue",ImmutableList.of()));
        Optional<User> user = userRepository.findByNameEquals("xue");
        assertTrue(user.isPresent());
        assertThat(user.get().getName(), is("xue"));
    }

    @Test
    public void shouldReturn401() throws Exception {
        mockmvc.perform(get("/todos"))
                .andExpect(unauthenticated());
    }

}