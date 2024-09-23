package com.dulich.tourism.repository;


import com.dulich.tourism.models.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
