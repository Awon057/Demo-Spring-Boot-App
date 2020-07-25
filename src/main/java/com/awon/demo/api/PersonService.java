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
	
	public void savePerson(PersonDTO dto) throws Exception{
		Person person = new Person();
		
		if(Objects.isNull(repository.findByMobileNo(dto.getMobileNo())))
			person.setMobileNo(dto.getMobileNo());
		else
			throw new NotFoundException("Error! This mobile no exists");

		person.setPersonName(dto.getPersonName());
		person.setAge(dto.getAge());
		person.setWeight(dto.getWeight());
		person.setHeight(dto.getHeight());
		repository.save(person);
	}
}
