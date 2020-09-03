package com.awon.demo.api;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	@Transactional
	public PersonDTO savePerson(PersonDTO dto) throws Exception {
		Person person = new Person();
		
		if(!Objects.isNull(repository.findByMobileNo(dto.getMobileNo()))) {
			dto.setStatus(203);
			dto.setMessage("Error! This mobile number exists");
			return dto;
//			throw new Exception("Error! This mobile number exists");
		}
		
		dto.setStatus(200);
		dto.setMessage("Success");
		person.setMobileNo(dto.getMobileNo());
		person.setPersonName(dto.getPersonName());
		person.setAge(dto.getAge());
		person.setWeight(dto.getWeight());
		person.setHeight(dto.getHeight());
		
		Role role = roleRepository.getOne(dto.getRoleID());
		
		System.out.println("role " + role.getId() + " " + role.getRoleName());
		System.out.println("dto " + dto.getRoleID());
		
		person.setRole(role);
		repository.save(person);
		return dto;
	}
}
