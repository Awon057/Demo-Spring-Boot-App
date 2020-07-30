package com.awon.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	public List<Role> findAll(){
		return repository.findAll();
	}
}
