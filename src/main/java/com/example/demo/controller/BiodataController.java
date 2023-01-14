package com.example.demo.controller;

import com.example.demo.model.Biodata;
import com.example.demo.model.dto.SignUpRequest;
import com.example.demo.service.BiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biodata")
public class BiodataController {
    private BiodataService biodataService;

    @Autowired
    public BiodataController(BiodataService biodataService){
        this.biodataService = biodataService;
    }

    @GetMapping
    public ResponseEntity<List<Biodata>> getAll(){
        return new ResponseEntity(biodataService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biodata> getById(@PathVariable Long id){
        return new ResponseEntity(biodataService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Biodata> create(@RequestBody SignUpRequest signUpRequest){
        return new ResponseEntity(biodataService.create(signUpRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biodata> update(@PathVariable Long id, @RequestBody Biodata biodata){
        return new ResponseEntity(biodataService.update(id, biodata), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Biodata> delete(@PathVariable Long id){
        return new ResponseEntity(biodataService.delete(id), HttpStatus.OK);
    }
}
