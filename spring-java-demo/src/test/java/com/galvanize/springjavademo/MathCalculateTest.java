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

@WebMvcTest(MathCalculate.class)
public class MathCalculateTest {

    @Autowired
    MockMvc mvc;


    @Test
    public void testMathcalculateAdd() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN)).
                andExpect(status().isOk()).andExpect(content().string("4+6 = 10"));
    }

    @Test
    public void testMathcalculateSubtract() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN)).
                andExpect(status().isOk()).andExpect(content().string("4-6 = -2"));
    }

    @Test
    public void testMathcalculateMultiply() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN)).
                andExpect(status().isOk()).andExpect(content().string("4*6 = 24"));
    }

    @Test
    public void testMathcalculateDivide() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=divide&x=10&y=5").accept(MediaType.TEXT_PLAIN)).
                andExpect(status().isOk()).andExpect(content().string("10/0 = 2"));
    }

}

