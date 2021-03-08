package com.example.demo.dao;
import com.example.demo.model.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    public List<Lesson> findAllByTitle(String title);

}