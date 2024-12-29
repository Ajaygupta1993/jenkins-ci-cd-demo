package com.agtech.jenkins;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class JenkinsPipeLineApplicationTests {

	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void testGreetings() throws Exception {
		String name="Ajay";
		
		mockmvc.perform(MockMvcRequestBuilders.get("/greetings/{name}",name)).andExpect(MockMvcResultMatchers.status().isOk())
		      .andExpect(MockMvcResultMatchers.content().string("Hello " + name +  "Congrats successfully deployed in CI CD"));
	}
}
