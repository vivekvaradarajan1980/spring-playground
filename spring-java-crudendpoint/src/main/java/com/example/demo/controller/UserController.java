package com.example.demo.controller;

import com.example.demo.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.dao.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    @JsonView(Views.regularView.class)
    public Iterable<User> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    @JsonView(Views.regularView.class)
    public User create(@RequestBody User user) {
        return this.repository.save(user);
    }

    @DeleteMapping("/{id}")
    public Map<String,Long> delete(@PathVariable Long id){

        Map<String,Long> remCount=new HashMap();
        this.repository.deleteById(id);
        Long cnt=this.repository.count();
        remCount.put("count",cnt);

        return remCount;

    }



    @PatchMapping("/{userID}")

    public User updateOrCreate(@RequestBody User user, @PathVariable Long userID) {

        Optional<User> old = this.repository.findById(userID);

        User actualold = new User();

        if (old.isPresent()) {
            actualold.setEmail(user.getEmail());
            actualold.setId(userID);
            if (!user.getPassword().equals(null)){
                actualold.setPassword(user.getPassword());}
            else{
                actualold.setPassword(old.get().getPassword());}

            return this.repository.save(actualold);

        }

        else {
            return this.repository.save(user);}


    }

    @PostMapping("/authenticate")
    @JsonView(Views.regularView.class)
    public Map<String,Object> authenticateUser(@RequestBody User user){

        Optional<User> existsUser=this.repository.findByEmail(user.getEmail());

        Map<String,Object> retAuth=new HashMap<>();

        boolean authenticate;

        if(existsUser.isPresent() & existsUser.get().getPassword().equals(user.getPassword())) {
            authenticate = true;
            retAuth.put("authenticated", authenticate);
            retAuth.put("user",user);

        }
        else {
            authenticate = false;
            retAuth.put("authenticated",authenticate);
        }


    return  retAuth;


    }

}