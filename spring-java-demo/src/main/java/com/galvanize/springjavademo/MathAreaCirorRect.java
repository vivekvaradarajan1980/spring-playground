package com.galvanize.springjavademo;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathAreaCirorRect {

    @PostMapping("/math/area")
    public String areaRet(@RequestParam Map<String,String> details) {


        String type;

        float area;

        type = details.get("type");


        if (type.equals("circle")) {

            if (details.containsKey("radius")) {

                int r;


                r = Integer.parseInt(details.get("radius"));
                area = (float) (r * r * 22.0 / 7);
                return String.valueOf(area);
            } else {

                return "Invalid entry";
            }

        } else if (type.equals("rectangle")) {

            if (details.containsKey("height") & details.containsKey("width")) {

                int l, w;
                l = Integer.parseInt(details.get("height"));
                w = Integer.parseInt(details.get("width"));
                area = l * w;
                return String.valueOf(area);
            }
            else return "Invalid entry";


        }

        return "youve reached bad spot";
    }

}
