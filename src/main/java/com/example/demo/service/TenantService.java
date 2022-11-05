package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.Tenant;
import com.example.demo.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class TenantService {
    private TenantRepository tenantRepository;
    private RoleService roleService;

    @Autowired
    public TenantService(TenantRepository tenantRepository, RoleService roleService){
        this.tenantRepository = tenantRepository;
        this.roleService = roleService;
    }

    public List<Tenant> getAll(){
        return tenantRepository.findAll();
    }

    public Tenant getById(Long id){
        return tenantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant doesn't exist"));
    }

    public Tenant create(Tenant tenant){
        if (tenant.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Tenant already exist");
        }
        findByName(tenant.getName());
        tenant.getUser().setTenant(tenant);

        List<Role> role = new ArrayList();
        role.add(roleService.getById(1L));
        tenant.getUser().setRoles(role);
        return tenantRepository.save(tenant);
    }

    public Tenant update(Long id, Tenant tenant){
        getById(id);
        tenant.setId(id);
        return tenantRepository.save(tenant);
    }

    public Tenant delete(Long id){
        Tenant tenant = getById(id);
        tenantRepository.delete(tenant);
        return tenant;
    }

    public void findByName(String name){
        if (tenantRepository.findByName(name).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tanant already exist");
        }
    }
}
