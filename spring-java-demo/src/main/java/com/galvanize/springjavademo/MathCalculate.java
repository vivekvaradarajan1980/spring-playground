package com.galvanize.springjavademo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathCalculate {

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam Map<String, String> queries) throws ArithmeticException {

        String operation;
        String opstring="" ;

        Integer x ;
        Integer y ;


        operation = queries.get("operation");
        x = Integer.parseInt(queries.get("x"));
        y = Integer.parseInt(queries.get("y"));

        Integer res = 0;

        if (operation.equals("add")) {
            res = x + y;
            opstring = "+";


        } else if (operation.equals("subtract")) {
            res = x - y;
            opstring = "-";
        } else if (operation.equals("multiply")) {
            res = x * y;
            opstring = "*";
        } else if (operation.equals("divide")) {

            try {
                res = x / y;

                opstring = "/";

            }

            catch (ArithmeticException e){
                return  e.getMessage();
            }
        }

        return x.toString() + opstring + y.toString() + " = " + res.toString();
    }
}
