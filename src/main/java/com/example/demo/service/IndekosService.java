package com.example.demo.service;

import com.example.demo.model.Indekos;
import com.example.demo.repository.IndekosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IndekosService {
    private IndekosRepository indekosRepository;

    @Autowired
    public IndekosService(IndekosRepository indekosRepository){
        this.indekosRepository=indekosRepository;
    }

    public List<Indekos> getAll(){
        return indekosRepository.findAll();
    }

    public Indekos getById(Long id){
        return indekosRepository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "indekos not found"));
    }

    public Indekos create(Indekos indekos){
        if(indekos.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "indekos already exist");
        }
        return indekosRepository.save(indekos);
    }

    public Indekos update(Long id, Indekos indekos){
        getById(id);
        indekos.setId(id);
        return indekosRepository.save(indekos);
    }
    public Indekos delete(Long id){
        Indekos indekos = getById(id);
        indekosRepository.delete(indekos);
        return indekos;
    }
}
