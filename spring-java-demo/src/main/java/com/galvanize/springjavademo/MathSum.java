package com.galvanize.springjavademo;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathSum {


      @PostMapping("/math/sum")
        public String mathSum(@RequestParam(value = "n")List<String> params){

            int sum=0;
            String out="";

            for(String item:params){
                sum += Integer.parseInt(item);

            }


           out= String.join(" + ",params);
            return out+ " = " +Integer.toString(sum);

        }


}


