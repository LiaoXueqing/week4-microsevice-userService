//package com.thoughtworks.training.xueqing.todoservice;
//
//import com.google.common.collect.ImmutableList;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.MvcResult;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TodoServiceApplicationTests {
//	@Autowired
//	private MockMvc mockmvc;
//
//	@MockBean
//	private TodoService todoService;
//
//	@Test
//	public void shouldReturn() throws Exception{
//		when(todoService.allTodos()).thenReturn(ImmutableList.of(
//				new TodoItem(1,"todos",false,false,"2018-7-30")
//		));
//
////		MvcResult result=
//				mockmvc.perform(get("/todos"))
//				.andExpect(status().is(200))
//				.andExpect(jsonPath("$.length()").value(1))
//				.andExpect(jsonPath("$.[0].id").value(1))
//				.andExpect(jsonPath("$.[0].name").value("todos"))
//				.andReturn();
//
////		System.out.println(result.getResponse().getContentAsString());
//	}
//
//
//}
