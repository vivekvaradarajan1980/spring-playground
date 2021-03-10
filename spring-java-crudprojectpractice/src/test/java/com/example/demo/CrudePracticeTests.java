package com.example.demo;

import com.example.demo.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;



import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CrudePracticeTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	EmployeeRepository repo;


	@Test
	@Transactional
	@Rollback
	public void createEmployee() throws Exception {

		this.mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"John\",\"date\":\"2018-03-04\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Programmer")));


		this.mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"James\",\"date\":\"2021-03-09\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Programmer")));

	}


	@Test
	@Transactional
	@Rollback

	public void readEmployee() throws Exception{

		this.mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Jeff\",\"date\":\"2018-03-04\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Programmer")));

		this.mvc.perform(get("/employees/3").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Jeff")));

	}


	@Test
	@Transactional
	@Rollback

	public void updateEmployee() throws Exception{



		this.mvc.perform(patch("/employees/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Jack\",\"date\":\"2020-03-04\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Jack")));

	}


	@Test
	@Transactional
	@Rollback

	public void deleteEmployee() throws Exception{


		this.mvc.perform(delete("/employees/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Jack")));

	}


	@Test
	@Transactional
	@Rollback

	public void readListEmployee() throws Exception{

		this.mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Jeff\",\"date\":\"2018-03-04\"}"))
				.andExpect(status().isOk());
		this.mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Jeff\",\"date\":\"2019-03-04\"}"))
				.andExpect(status().isOk());
		this.mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Jeff\",\"date\":\"2020-03-04\"}"))
				.andExpect(status().isOk());

		this.mvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name",is("Jeff")));

	}








}
