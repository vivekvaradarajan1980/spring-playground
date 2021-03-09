package com.example.demo;

import com.example.demo.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.http.RequestEntity.patch;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {


	@Autowired
	MockMvc mvc;
	@Autowired
    UserRepository repotest;


	@Test
	@Transactional
	@Rollback
	public void createTest() throws Exception
	{

		this.mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\":\"abcd@randomdomain.com\",\"password\":\"secret-password\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.email",is("abcd@randomdomain.com")));

	}



	@Test
	@Transactional
	@Rollback
	public void getTest() throws Exception
	{

		this.mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\":\"varadarajan.vivek@gmail.com\",\"password\":\"secret-password\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.email",is("abcd@rabdomdomain.com")));

		this.mvc.perform(get("/users").contentType(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[6].email",is("varadarajan.vivek@gmail.com")));


	}

	@Test
	@Transactional
	@Rollback
	public void patchTest() throws Exception
	{

		this.mvc.perform(MockMvcRequestBuilders.patch("/users/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\":\"abcd@randomdomain.com\",\"password\":\"randomchanged\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id",is(15)));



	}


	@Test
	@Transactional
	@Rollback
	public void delTest() throws Exception{


		this.mvc.perform(delete("/users/18").contentType(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.count",is(2)));


	}



}
