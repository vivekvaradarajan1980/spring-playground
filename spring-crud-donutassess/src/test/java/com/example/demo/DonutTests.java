package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DonutRepository;
import javax.persistence.Table;
import javax.transaction.Transactional;

import java.text.SimpleDateFormat;

import static org.springframework.http.RequestEntity.patch;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DonutTests {

    @Autowired
    MockMvc mvc;

    @Autowired
     DonutRepository donutRepository;

    @Test
    @Rollback
    @Transactional
    public void createTest() throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Donut donut=new Donut("creamfilled","chocolate",dateFormat.parse("2021-12-31"));
        String store=mapper.writeValueAsString(donut);

        this.mvc.perform(post("/donuts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(store))
                .andExpect(jsonPath("$.name",is("creamfilled")))
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    @Rollback
    public void updateDonutTest() throws Exception {

        ObjectMapper mapper=new ObjectMapper();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Donut donut=new Donut("creamfilled","chocolate",dateFormat.parse("2021-12-31"));
        String store=mapper.writeValueAsString(donut);

        this.donutRepository.save(donut);
        //get the field for update
        Long idtest=donut.getId();

        // new donut for update
        donut=new Donut("creamfilled","vanilla",dateFormat.parse("2021-12-31"));
        store=mapper.writeValueAsString(donut);
        this.mvc.perform(MockMvcRequestBuilders.patch("/donuts/"+idtest)
                .contentType(MediaType.APPLICATION_JSON)
                 .content(store))
                .andExpect(jsonPath("$.topping",is("vanilla")))
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    @Rollback
    public void deleteTest() throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Donut donut = new Donut("creamfilled", "chocolate", dateFormat.parse("2021-12-31"));
        String store = mapper.writeValueAsString(donut);

        this.donutRepository.save(donut);
        Long idtest = donut.getId();

        // just checkiing to see if delete status is ok ...nothing returned from method
        this.mvc.perform(delete("/donuts/"+idtest))
                .andExpect(status().isOk());



    }


    @Test
    @Transactional
    @Rollback
    public  void readOneTest() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Donut donut = new Donut("creamfilled", "chocolate", dateFormat.parse("2021-12-31"));
        String store = mapper.writeValueAsString(donut);

        this.donutRepository.save(donut);
        Long idtest = donut.getId();


        this.mvc.perform(get("/donuts/"+idtest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("creamfilled")));


    }

    @Test
    @Transactional
    @Rollback
    public  void getallTest() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Donut donut=new Donut("creamfilled","chocolate",dateFormat.parse("2021-12-31"));
        String store=mapper.writeValueAsString(donut);
        this.mvc.perform(post("/donuts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(store))
                .andExpect(jsonPath("$.name",is("creamfilled")))
                .andExpect(status().isOk());



        donut=new Donut("creamfilled","vanilla",dateFormat.parse("2021-09-31"));
        store=mapper.writeValueAsString(donut);
        this.mvc.perform(post("/donuts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(store))
                .andExpect(jsonPath("$.name",is("creamfilled")))
                .andExpect(status().isOk());



        this.mvc.perform(get("/donuts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].topping",is("vanilla")))
                .andExpect(jsonPath("$[0].topping",is("chocolate")));





    }


}
