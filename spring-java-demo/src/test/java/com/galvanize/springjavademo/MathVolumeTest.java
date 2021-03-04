package com.galvanize.springjavademo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(MathVolume.class)
public class MathVolumeTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testMathVolume() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3X4X5 rectangle is 60"));

        this.mvc.perform(get("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3X4X5 rectangle is 60"));

        this.mvc.perform(patch("/math/volume/3/4/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3X4X2 rectangle is 24"));

        this.mvc.perform(delete("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3X4X5 rectangle is 60"));

    }

}
