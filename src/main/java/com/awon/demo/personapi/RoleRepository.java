package com.awon.demo.personapi;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
