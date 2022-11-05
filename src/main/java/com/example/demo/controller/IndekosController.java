package com.example.demo.controller;

import com.example.demo.model.Indekos;
import com.example.demo.service.IndekosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indekos")
public class IndekosController {
    private IndekosService indekosService;

    @Autowired
    public IndekosController(IndekosService indekosService){
        this.indekosService = indekosService;
    }

    @GetMapping
    public ResponseEntity<List<Indekos>> getAll(){
        return new ResponseEntity(indekosService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Indekos> getById(@PathVariable Long id){
//        return indekosService.getById(id);
        return new ResponseEntity(indekosService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Indekos> create(@RequestBody Indekos indekos){
//        return indekosService.create(indekos);
        return new ResponseEntity(indekosService.create(indekos), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Indekos> update(@PathVariable Long id, @RequestBody Indekos indekos){
//        return indekosService.update(id, indekos);
        return new ResponseEntity(indekosService.update(id, indekos), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Indekos> delete(@PathVariable Long id){
//        return indekosService.delete(id);
        return new ResponseEntity(indekosService.delete(id), HttpStatus.OK);
    }
}
