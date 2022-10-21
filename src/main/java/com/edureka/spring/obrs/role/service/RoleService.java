package com.edureka.spring.obrs.role.service;
//Kishlay Kishan
import com.edureka.spring.obrs.common.service.CRUDService;
import com.edureka.spring.obrs.role.entity.Role;

public interface RoleService extends CRUDService<Role> {
    Role findByRole(String role);
}
