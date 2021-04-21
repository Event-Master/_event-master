package com.jaforest.Event.Master;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class EventMasterApplicationTests {


	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect(status().isOk());
	}

	@Test
	void testSignUpPage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect(status().isOk());
	}

	@Test
	void testLoginPage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect(status().isOk());
	}

	@Test
	void testCalendarPage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect((content().string(containsString(""))))
				.andExpect(status().isOk());
	}

}
