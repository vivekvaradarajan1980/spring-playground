package com.galvanize.springjavademo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testHelloWorld() throws Exception{

        this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN)).
                andExpect(status().isOk()).andExpect(content().string("Hellow World"));
    }


    @Test
    public void testMathpireturn() throws Exception {

        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN)).
                andExpect(status().isOk()).andExpect(content().string("3.142857142857143"));
    }

}



