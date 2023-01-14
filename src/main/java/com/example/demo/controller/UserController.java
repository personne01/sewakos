package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.BiodataService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private BiodataService biodataService;


    @Autowired
    public UserController(UserService userService, BiodataService biodataService){
        this.userService = userService;
        this.biodataService = biodataService;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }



    @PutMapping("/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return userService.update(id, user);
    }
    @DeleteMapping("/{id}")
    public User delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
