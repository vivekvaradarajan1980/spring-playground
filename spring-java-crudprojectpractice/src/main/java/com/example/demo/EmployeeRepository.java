package com.example.demo;

import com.example.demo.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {



    }
