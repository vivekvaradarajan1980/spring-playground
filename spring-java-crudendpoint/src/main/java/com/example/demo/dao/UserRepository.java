package com.example.demo.dao;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByEmail(String title);

}