package com.example.demo;

import com.example.demo.dao.LessonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.beans.Transient;

import static org.springframework.http.RequestEntity.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LessonsApplicationTests {


	@Autowired
	MockMvc mvc;
	@Autowired
	LessonRepository repotest;


	@Test
	@Transactional
	@Rollback
	public void createTest() throws Exception
	{


		this.mvc.perform(post("/lessons").contentType(MediaType.APPLICATION_JSON)
			.content("{\"title\":\"Programmer\",\"date\":\"2018-03-04\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title",is("Programmer")));





	}



	@Test
	@Transactional
	@Rollback
	public void getTest() throws Exception
	{


		this.mvc.perform(post("/lessons").contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\":\"Programmer\",\"date\":\"2018-03-04\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title",is("Programmer")));


		this.mvc.perform(get("/lessons/name/Programmer").contentType(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].title",is("Programmer")));


	}


	@Test
	@Transactional
	@Rollback
	public void patchTest() throws Exception
	{



		this.mvc.perform(MockMvcRequestBuilders.patch("/lessons/31").contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\":\"Programmer\",\"date\":\"2018-03-04\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id",is(37)));



	}



}
