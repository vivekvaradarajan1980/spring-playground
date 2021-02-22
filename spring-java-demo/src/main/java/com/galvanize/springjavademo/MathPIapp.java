package com.galvanize.springjavademo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MathPIapp {

    @GetMapping("/math/pi")
    public String Mathreturn(){
        return  "3.141592653589793";


    }
}
