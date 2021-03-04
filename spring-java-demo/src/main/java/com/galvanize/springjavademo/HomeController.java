package com.galvanize.springjavademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String HelloWorld(){

        return "Hellow World";
    }

    @GetMapping("/math/pi")
    public String Mathreturn(){

        return "3.142857142857143";

    }


}
