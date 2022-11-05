package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }
    public Role getById(Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Role nor found"));
    }

    public Role create(Role role){
        if (role.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "role already exist");
        }
        return roleRepository.save(role);
    }
    public Role update(Long id, Role role){
        getById(id);
        role.setId(id);
        return roleRepository.save(role);
    }
    public Role delete(Long id){
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }
}
