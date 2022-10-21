package com.edureka.spring.obrs.role.service;
//Kishlay Kishan
import com.edureka.spring.obrs.role.entity.Role;
import com.edureka.spring.obrs.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<?> findAll() {
        List<Role> roles = new ArrayList<>();
        this.roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role findById(Integer id) {
        return this.roleRepository.findById(id).get();
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepository.save(domainObject);
    }

    @Override
    public void deleteById(Integer id) {
        this.roleRepository.deleteById(id);
    }

    @Override
    public Role findByRole(String role) {
        return this.roleRepository.findByRole(role);
    }
}
