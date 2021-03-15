package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


public interface DonutRepository extends CrudRepository<Donut, Long> {


}