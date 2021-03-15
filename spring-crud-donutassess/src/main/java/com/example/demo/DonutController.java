package com.example.demo;

import org.springframework.web.bind.annotation.*;

import com.example.demo.DonutRepository;
import com.example.demo.Donut;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/donuts")
public class DonutController {


    private final DonutRepository donutRepository;

   public DonutController(DonutRepository donutRepository) {
        this.donutRepository=donutRepository;
    }


    // save a new donut
    @PostMapping("")
    public Donut createDonut(@RequestBody Donut donut){

       return this.donutRepository.save(donut);

    }

    // return donut by id if found if not return null...
    @GetMapping("{id}")
    public Optional<Donut> retDonutbyID(@PathVariable Long id){

        return this.donutRepository.findById(id);

    }

    @PatchMapping("{id}")
    public Donut updateDonutById(@PathVariable Long id, @RequestBody Donut donut){

       Optional<Donut> existdonut=this.donutRepository.findById(id);

       // if old donut is present then set the id of the update donate to the old id
       if(existdonut.isPresent()) {
           donut.setId(existdonut.get().getId());
           this.donutRepository.save(donut);
       }

       else {

           this.donutRepository.save(donut);
        }

       return donut;
    }

    @DeleteMapping("{id}")
    public void deleteDonutById(@PathVariable Long id){

       this.donutRepository.deleteById(id);
    }


    // Return list of all existing donnuts...
    @GetMapping("")
    public Iterable<Donut> returAllDonuts(){

       return this.donutRepository.findAll();

   }

}
