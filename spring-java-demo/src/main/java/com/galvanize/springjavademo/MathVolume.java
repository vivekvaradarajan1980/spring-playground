package com.galvanize.springjavademo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math/volume")
public class MathVolume {

    @PostMapping("/{length}/{width}/{height}")
    public String volumePost(@PathVariable int length, @PathVariable int width, @PathVariable int  height){


        return String.format("The volume of a %dX%dX%d rectangle is "+length*width*height, length,width, height);
    }

    @GetMapping("/{length}/{width}/{height}")
    public String volumeGet(@PathVariable int length, @PathVariable int width, @PathVariable int  height){


        return String.format("The volume of a %dX%dX%d rectangle is "+length*width*height, length,width, height);
    }

    @PatchMapping("/{length}/{width}/{height}")
    public String volumePatch(@PathVariable int length, @PathVariable int width, @PathVariable int  height){


        return String.format("The volume of a %dX%dX%d rectangle is "+length*width*height, length,width, height);
    }

    @DeleteMapping("/{length}/{width}/{height}")
    public String volumeDelete(@PathVariable int length, @PathVariable int width, @PathVariable int  height){


        return String.format("The volume of a %dX%dX%d rectangle is "+length*width*height, length,width, height);
    }
}
