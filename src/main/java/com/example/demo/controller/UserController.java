package com.example.demo.controller;

import com.example.demo.model.Tenant;
import com.example.demo.model.User;
import com.example.demo.service.TenantService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private TenantService tenantService;


    @Autowired
    public UserController(UserService userService, TenantService tenantService){
        this.userService = userService;
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PostMapping
    public ResponseEntity<Tenant> create(@RequestBody Tenant tenant){
        return new ResponseEntity(tenantService.create(tenant), HttpStatus.CREATED);
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
