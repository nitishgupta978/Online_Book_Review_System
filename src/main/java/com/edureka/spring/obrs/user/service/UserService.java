package com.edureka.spring.obrs.user.service;

import com.edureka.spring.obrs.common.service.CRUDService;
import com.edureka.spring.obrs.user.entity.User;

import java.util.List;

public interface UserService extends CRUDService<User> {
//    List<?> findAllWithRole();

    User registerNewUser(User user, String role);

    User findByUsername(String username);

    boolean existsById(Integer id);

    List<?> findUsersByRoles(String role);
}
