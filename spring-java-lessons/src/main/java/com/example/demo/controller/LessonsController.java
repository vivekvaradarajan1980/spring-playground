package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Lesson;
import com.example.demo.dao.LessonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

         this.repository.deleteById(id);
    }


    @GetMapping("/name/{byname}")
    public List<Lesson> findtitle(@PathVariable String byname){

       return this.repository.findAllByTitle(byname);
    }



    @PatchMapping("/{lessonID}")

    public Lesson updateOrCreate(@RequestBody Lesson lesson, @PathVariable Long lessonID){

        Optional<Lesson> old=this.repository.findById(lessonID);

        Lesson actualold=new Lesson();



        if(old.isPresent()){

            actualold.setDeliveredOn(lesson.getDeliveredOn());
            actualold.setTitle(lesson.getTitle());
            actualold.setId(lessonID);

          return this.repository.save(actualold);
        }

        else
            return this.repository.save(lesson);

    }


}