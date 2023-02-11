package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.Biodata;
import com.example.demo.model.User;
import com.example.demo.model.dto.SignUpRequest;
import com.example.demo.repository.BiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class BiodataService {
    private BiodataRepository biodataRepository;
    private RoleService roleService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public BiodataService(BiodataRepository biodataRepository, RoleService roleService){
        this.biodataRepository = biodataRepository;
        this.roleService = roleService;
    }

    public List<Biodata> getAll(){
        return biodataRepository.findAll();
    }

    public Biodata getById(Long id){
        return biodataRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant doesn't exist"));
    }

    public Biodata create(SignUpRequest signUpRequest){
        Biodata biodata = new Biodata();
        biodata.setName(signUpRequest.getName());
        biodata.setEmail(signUpRequest.getEmail());
        biodata.setNik(signUpRequest.getNik());
        biodata.setGender(signUpRequest.getGender());
        biodata.setPhone(signUpRequest.getPhone());

        User user = new User();
        user.setName(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        List<Role> role = new ArrayList();
        role.add(roleService.getById(signUpRequest.getRolesId()));
        user.setRoles(role);


        biodata.setUser(user);
        user.setBiodata(biodata);

        return biodataRepository.save(biodata);
    }

    public Biodata update(Long id, Biodata biodata){
        getById(id);
        biodata.setId(id);
        return biodataRepository.save(biodata);
    }

    public Biodata delete(Long id){
        Biodata biodata = getById(id);
        biodataRepository.delete(biodata);
        return biodata;
    }

    public void findByName(String name){
        if (biodataRepository.findByName(name).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tenant already exist");
        }
    }
}
