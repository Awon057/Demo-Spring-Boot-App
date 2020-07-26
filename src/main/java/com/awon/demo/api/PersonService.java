package com.awon.demo.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class PersonService extends CommonService<Person> {

	@Autowired
	private PersonRepository repository;
	
	public PersonService(JpaRepository<Person, Long> repository) {
		super(repository);
		this.repository = (PersonRepository)repository;
	}
	
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
		repository.save(person);
		return dto;
	}
}
