package com.example.demo.controller;

import com.example.demo.model.Tenant;
import com.example.demo.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    private TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService){
        this.tenantService = tenantService;
    }

    @GetMapping
    public ResponseEntity<Tenant> getAll(){
        return new ResponseEntity(tenantService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getById(Long id){
        return new ResponseEntity(tenantService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tenant> create(Tenant tenant){
        return new ResponseEntity(tenantService.create(tenant), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tenant> update(Long id, Tenant tenant){
        return new ResponseEntity(tenantService.update(id, tenant), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tenant> delete(Long id){
        return new ResponseEntity(tenantService.delete(id), HttpStatus.OK);
    }
}
