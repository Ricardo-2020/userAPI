package com.tts.userapi.controllor;

import java.util.List;
import java.util.Optional;

import com.tts.userapi.model.User;
import com.tts.userapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/")
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable(value="id") Long id){
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public void createUser(@PathVariable(value="id") Long id, @RequestBody User user){
        userRepository.save(user);
    }




}
