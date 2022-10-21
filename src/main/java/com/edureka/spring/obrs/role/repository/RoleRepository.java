package com.edureka.spring.obrs.role.repository;
//Kishlay Kishan
import com.edureka.spring.obrs.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRole(String role);

    @Override
    void delete(Role role);
}
